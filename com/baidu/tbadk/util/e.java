package com.baidu.tbadk.util;

import android.graphics.Color;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static LinkedList<Integer> II;

    public static int Qv() {
        return ap(null);
    }

    public static int ap(List<Integer> list) {
        if (II == null) {
            awq();
        }
        Integer aq = aq(list);
        return aq != null ? aq.intValue() : R.color.cp_atp_a;
    }

    public static int lc(int i) {
        Color.colorToHSV(am.getColor(i), r0);
        float[] fArr = {0.0f, 0.83f, 0.66f};
        return Color.HSVToColor(fArr);
    }

    private static void awq() {
        II = new LinkedList<>();
        II.offer(Integer.valueOf((int) R.color.cp_atp_a));
        II.offer(Integer.valueOf((int) R.color.cp_atp_b));
        II.offer(Integer.valueOf((int) R.color.cp_atp_c));
        II.offer(Integer.valueOf((int) R.color.cp_atp_d));
        II.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer aq(List<Integer> list) {
        Integer peek = II.peek();
        if (list == null || list.size() == 0) {
            II.offer(II.poll());
            return peek;
        } else if (list.size() > 4) {
            II.offer(II.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= II.size()) {
                    i = 0;
                    break;
                }
                Integer num = II.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = II.remove(i);
            II.offer(remove);
            return remove;
        }
    }
}
