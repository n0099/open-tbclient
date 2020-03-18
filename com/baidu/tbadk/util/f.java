package com.baidu.tbadk.util;

import android.graphics.Color;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static LinkedList<Integer> xS;

    public static int aSb() {
        return aM(null);
    }

    public static int aM(List<Integer> list) {
        if (xS == null) {
            generate();
        }
        Integer aN = aN(list);
        return aN != null ? aN.intValue() : R.color.cp_atp_a;
    }

    public static int mU(int i) {
        Color.colorToHSV(am.getColor(i), r0);
        float[] fArr = {0.0f, 0.83f, 0.75f};
        return Color.HSVToColor(fArr);
    }

    private static void generate() {
        xS = new LinkedList<>();
        xS.offer(Integer.valueOf((int) R.color.cp_atp_a));
        xS.offer(Integer.valueOf((int) R.color.cp_atp_b));
        xS.offer(Integer.valueOf((int) R.color.cp_atp_c));
        xS.offer(Integer.valueOf((int) R.color.cp_atp_d));
        xS.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer aN(List<Integer> list) {
        Integer peek = xS.peek();
        if (list == null || list.size() == 0) {
            xS.offer(xS.poll());
            return peek;
        } else if (list.size() > 4) {
            xS.offer(xS.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= xS.size()) {
                    i = 0;
                    break;
                }
                Integer num = xS.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = xS.remove(i);
            xS.offer(remove);
            return remove;
        }
    }
}
