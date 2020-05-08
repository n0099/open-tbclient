package com.baidu.tbadk.util;

import android.graphics.Color;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static LinkedList<Integer> QZ;

    public static int bai() {
        return aW(null);
    }

    public static int aW(List<Integer> list) {
        if (QZ == null) {
            generate();
        }
        Integer aX = aX(list);
        return aX != null ? aX.intValue() : R.color.cp_atp_a;
    }

    public static int nf(int i) {
        Color.colorToHSV(am.getColor(i), r0);
        float[] fArr = {0.0f, 0.83f, 0.75f};
        return Color.HSVToColor(fArr);
    }

    private static void generate() {
        QZ = new LinkedList<>();
        QZ.offer(Integer.valueOf((int) R.color.cp_atp_a));
        QZ.offer(Integer.valueOf((int) R.color.cp_atp_b));
        QZ.offer(Integer.valueOf((int) R.color.cp_atp_c));
        QZ.offer(Integer.valueOf((int) R.color.cp_atp_d));
        QZ.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer aX(List<Integer> list) {
        Integer peek = QZ.peek();
        if (list == null || list.size() == 0) {
            QZ.offer(QZ.poll());
            return peek;
        } else if (list.size() > 4) {
            QZ.offer(QZ.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= QZ.size()) {
                    i = 0;
                    break;
                }
                Integer num = QZ.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = QZ.remove(i);
            QZ.offer(remove);
            return remove;
        }
    }
}
