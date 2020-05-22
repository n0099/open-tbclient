package com.baidu.tbadk.util;

import android.graphics.Color;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static LinkedList<Integer> Rk;

    public static int bgs() {
        return aR(null);
    }

    public static int aR(List<Integer> list) {
        if (Rk == null) {
            generate();
        }
        Integer aS = aS(list);
        return aS != null ? aS.intValue() : R.color.cp_atp_a;
    }

    public static int nH(int i) {
        Color.colorToHSV(am.getColor(i), r0);
        float[] fArr = {0.0f, 0.83f, 0.75f};
        return Color.HSVToColor(fArr);
    }

    private static void generate() {
        Rk = new LinkedList<>();
        Rk.offer(Integer.valueOf((int) R.color.cp_atp_a));
        Rk.offer(Integer.valueOf((int) R.color.cp_atp_b));
        Rk.offer(Integer.valueOf((int) R.color.cp_atp_c));
        Rk.offer(Integer.valueOf((int) R.color.cp_atp_d));
        Rk.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer aS(List<Integer> list) {
        Integer peek = Rk.peek();
        if (list == null || list.size() == 0) {
            Rk.offer(Rk.poll());
            return peek;
        } else if (list.size() > 4) {
            Rk.offer(Rk.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= Rk.size()) {
                    i = 0;
                    break;
                }
                Integer num = Rk.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = Rk.remove(i);
            Rk.offer(remove);
            return remove;
        }
    }
}
