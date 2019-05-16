package com.baidu.tbadk.util;

import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static LinkedList<Integer> Ix;

    public static int get() {
        return ap(null);
    }

    public static int ap(List<Integer> list) {
        if (Ix == null) {
            auT();
        }
        Integer aq = aq(list);
        return aq != null ? aq.intValue() : R.color.cp_atp_a;
    }

    private static void auT() {
        Ix = new LinkedList<>();
        Ix.offer(Integer.valueOf((int) R.color.cp_atp_a));
        Ix.offer(Integer.valueOf((int) R.color.cp_atp_b));
        Ix.offer(Integer.valueOf((int) R.color.cp_atp_c));
        Ix.offer(Integer.valueOf((int) R.color.cp_atp_d));
        Ix.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer aq(List<Integer> list) {
        Integer peek = Ix.peek();
        if (list == null || list.size() == 0) {
            Ix.offer(Ix.poll());
            return peek;
        } else if (list.size() > 4) {
            Ix.offer(Ix.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= Ix.size()) {
                    i = 0;
                    break;
                }
                Integer num = Ix.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = Ix.remove(i);
            Ix.offer(remove);
            return remove;
        }
    }
}
