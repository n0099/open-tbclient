package com.baidu.tbadk.util;

import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static LinkedList<Integer> Iw;

    public static int get() {
        return ap(null);
    }

    public static int ap(List<Integer> list) {
        if (Iw == null) {
            auT();
        }
        Integer aq = aq(list);
        return aq != null ? aq.intValue() : R.color.cp_atp_a;
    }

    private static void auT() {
        Iw = new LinkedList<>();
        Iw.offer(Integer.valueOf((int) R.color.cp_atp_a));
        Iw.offer(Integer.valueOf((int) R.color.cp_atp_b));
        Iw.offer(Integer.valueOf((int) R.color.cp_atp_c));
        Iw.offer(Integer.valueOf((int) R.color.cp_atp_d));
        Iw.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer aq(List<Integer> list) {
        Integer peek = Iw.peek();
        if (list == null || list.size() == 0) {
            Iw.offer(Iw.poll());
            return peek;
        } else if (list.size() > 4) {
            Iw.offer(Iw.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= Iw.size()) {
                    i = 0;
                    break;
                }
                Integer num = Iw.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = Iw.remove(i);
            Iw.offer(remove);
            return remove;
        }
    }
}
