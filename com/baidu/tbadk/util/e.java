package com.baidu.tbadk.util;

import android.graphics.Color;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static LinkedList<Integer> vu;

    public static int Vl() {
        return aH(null);
    }

    public static int aH(List<Integer> list) {
        if (vu == null) {
            axv();
        }
        Integer aI = aI(list);
        return aI != null ? aI.intValue() : R.color.cp_atp_a;
    }

    public static int kn(int i) {
        Color.colorToHSV(am.getColor(i), r0);
        float[] fArr = {0.0f, 0.83f, 0.66f};
        return Color.HSVToColor(fArr);
    }

    private static void axv() {
        vu = new LinkedList<>();
        vu.offer(Integer.valueOf((int) R.color.cp_atp_a));
        vu.offer(Integer.valueOf((int) R.color.cp_atp_b));
        vu.offer(Integer.valueOf((int) R.color.cp_atp_c));
        vu.offer(Integer.valueOf((int) R.color.cp_atp_d));
        vu.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer aI(List<Integer> list) {
        Integer peek = vu.peek();
        if (list == null || list.size() == 0) {
            vu.offer(vu.poll());
            return peek;
        } else if (list.size() > 4) {
            vu.offer(vu.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= vu.size()) {
                    i = 0;
                    break;
                }
                Integer num = vu.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = vu.remove(i);
            vu.offer(remove);
            return remove;
        }
    }
}
