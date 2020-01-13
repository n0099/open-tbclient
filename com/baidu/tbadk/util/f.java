package com.baidu.tbadk.util;

import android.graphics.Color;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static LinkedList<Integer> xA;

    public static int aPD() {
        return aM(null);
    }

    public static int aM(List<Integer> list) {
        if (xA == null) {
            generate();
        }
        Integer aN = aN(list);
        return aN != null ? aN.intValue() : R.color.cp_atp_a;
    }

    public static int mB(int i) {
        Color.colorToHSV(am.getColor(i), r0);
        float[] fArr = {0.0f, 0.83f, 0.75f};
        return Color.HSVToColor(fArr);
    }

    private static void generate() {
        xA = new LinkedList<>();
        xA.offer(Integer.valueOf((int) R.color.cp_atp_a));
        xA.offer(Integer.valueOf((int) R.color.cp_atp_b));
        xA.offer(Integer.valueOf((int) R.color.cp_atp_c));
        xA.offer(Integer.valueOf((int) R.color.cp_atp_d));
        xA.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer aN(List<Integer> list) {
        Integer peek = xA.peek();
        if (list == null || list.size() == 0) {
            xA.offer(xA.poll());
            return peek;
        } else if (list.size() > 4) {
            xA.offer(xA.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= xA.size()) {
                    i = 0;
                    break;
                }
                Integer num = xA.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = xA.remove(i);
            xA.offer(remove);
            return remove;
        }
    }
}
