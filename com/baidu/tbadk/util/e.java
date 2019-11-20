package com.baidu.tbadk.util;

import android.graphics.Color;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static LinkedList<Integer> uT;

    public static int Vj() {
        return aH(null);
    }

    public static int aH(List<Integer> list) {
        if (uT == null) {
            axt();
        }
        Integer aI = aI(list);
        return aI != null ? aI.intValue() : R.color.cp_atp_a;
    }

    public static int km(int i) {
        Color.colorToHSV(am.getColor(i), r0);
        float[] fArr = {0.0f, 0.83f, 0.66f};
        return Color.HSVToColor(fArr);
    }

    private static void axt() {
        uT = new LinkedList<>();
        uT.offer(Integer.valueOf((int) R.color.cp_atp_a));
        uT.offer(Integer.valueOf((int) R.color.cp_atp_b));
        uT.offer(Integer.valueOf((int) R.color.cp_atp_c));
        uT.offer(Integer.valueOf((int) R.color.cp_atp_d));
        uT.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer aI(List<Integer> list) {
        Integer peek = uT.peek();
        if (list == null || list.size() == 0) {
            uT.offer(uT.poll());
            return peek;
        } else if (list.size() > 4) {
            uT.offer(uT.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= uT.size()) {
                    i = 0;
                    break;
                }
                Integer num = uT.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = uT.remove(i);
            uT.offer(remove);
            return remove;
        }
    }
}
