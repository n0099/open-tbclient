package com.baidu.tbadk.util;

import android.graphics.Color;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static LinkedList<Integer> xw;

    public static int aPk() {
        return aN(null);
    }

    public static int aN(List<Integer> list) {
        if (xw == null) {
            generate();
        }
        Integer aO = aO(list);
        return aO != null ? aO.intValue() : R.color.cp_atp_a;
    }

    public static int mB(int i) {
        Color.colorToHSV(am.getColor(i), r0);
        float[] fArr = {0.0f, 0.83f, 0.75f};
        return Color.HSVToColor(fArr);
    }

    private static void generate() {
        xw = new LinkedList<>();
        xw.offer(Integer.valueOf((int) R.color.cp_atp_a));
        xw.offer(Integer.valueOf((int) R.color.cp_atp_b));
        xw.offer(Integer.valueOf((int) R.color.cp_atp_c));
        xw.offer(Integer.valueOf((int) R.color.cp_atp_d));
        xw.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer aO(List<Integer> list) {
        Integer peek = xw.peek();
        if (list == null || list.size() == 0) {
            xw.offer(xw.poll());
            return peek;
        } else if (list.size() > 4) {
            xw.offer(xw.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= xw.size()) {
                    i = 0;
                    break;
                }
                Integer num = xw.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = xw.remove(i);
            xw.offer(remove);
            return remove;
        }
    }
}
