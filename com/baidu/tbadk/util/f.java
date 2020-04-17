package com.baidu.tbadk.util;

import android.graphics.Color;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static LinkedList<Integer> QW;

    public static int bak() {
        return aW(null);
    }

    public static int aW(List<Integer> list) {
        if (QW == null) {
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
        QW = new LinkedList<>();
        QW.offer(Integer.valueOf((int) R.color.cp_atp_a));
        QW.offer(Integer.valueOf((int) R.color.cp_atp_b));
        QW.offer(Integer.valueOf((int) R.color.cp_atp_c));
        QW.offer(Integer.valueOf((int) R.color.cp_atp_d));
        QW.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer aX(List<Integer> list) {
        Integer peek = QW.peek();
        if (list == null || list.size() == 0) {
            QW.offer(QW.poll());
            return peek;
        } else if (list.size() > 4) {
            QW.offer(QW.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= QW.size()) {
                    i = 0;
                    break;
                }
                Integer num = QW.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = QW.remove(i);
            QW.offer(remove);
            return remove;
        }
    }
}
