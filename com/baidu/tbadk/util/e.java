package com.baidu.tbadk.util;

import com.baidu.tieba.d;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static LinkedList<Integer> KM;

    public static int get() {
        return ai(null);
    }

    public static int ai(List<Integer> list) {
        if (KM == null) {
            apS();
        }
        Integer aj = aj(list);
        return aj != null ? aj.intValue() : d.C0277d.cp_atp_a;
    }

    private static void apS() {
        KM = new LinkedList<>();
        KM.offer(Integer.valueOf(d.C0277d.cp_atp_a));
        KM.offer(Integer.valueOf(d.C0277d.cp_atp_b));
        KM.offer(Integer.valueOf(d.C0277d.cp_atp_c));
        KM.offer(Integer.valueOf(d.C0277d.cp_atp_d));
        KM.offer(Integer.valueOf(d.C0277d.cp_atp_e));
    }

    private static Integer aj(List<Integer> list) {
        Integer peek = KM.peek();
        if (list == null || list.size() == 0) {
            KM.offer(KM.poll());
            return peek;
        } else if (list.size() > 4) {
            KM.offer(KM.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= KM.size()) {
                    i = 0;
                    break;
                }
                Integer num = KM.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = KM.remove(i);
            KM.offer(remove);
            return remove;
        }
    }
}
