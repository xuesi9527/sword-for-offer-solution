import java.util.ArrayList;

/**
 * 采用书上说的交换的解法
 * 这种做法没有去重
 */
public class Solution2 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        int len = str.length();
        if (len == 0) {
            return res;
        }
        findPermutation(str.toCharArray(), 0, len, res);
        return res;
    }

    private void findPermutation(char[] chars, int begin, int len, ArrayList<String> res) {
        if (begin == len - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        for (int i = begin; i < len; i++) {
            swap(chars, begin, i);
            findPermutation(chars, begin + 1, len, res);
            swap(chars, begin, i);
        }
    }

    private void swap(char[] arr, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ArrayList<String> permutation = solution2.Permutation("aac");
        System.out.println(permutation);
    }
}

