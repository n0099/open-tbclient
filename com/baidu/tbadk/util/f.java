package com.baidu.tbadk.util;

import android.graphics.Color;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static LinkedList<Integer> RL;

    public static int biH() {
        return bb(null);
    }

    public static int bb(List<Integer> list) {
        if (RL == null) {
            generate();
        }
        Integer bc = bc(list);
        return bc != null ? bc.intValue() : R.color.cp_atp_a;
    }

    public static int of(int i) {
        Color.colorToHSV(an.getColor(i), r0);
        float[] fArr = {0.0f, 0.83f, 0.75f};
        return Color.HSVToColor(fArr);
    }

    private static void generate() {
        RL = new LinkedList<>();
        RL.offer(Integer.valueOf((int) R.color.cp_atp_a));
        RL.offer(Integer.valueOf((int) R.color.cp_atp_b));
        RL.offer(Integer.valueOf((int) R.color.cp_atp_c));
        RL.offer(Integer.valueOf((int) R.color.cp_atp_d));
        RL.offer(Integer.valueOf((int) R.color.cp_atp_e));
    }

    private static Integer bc(List<Integer> list) {
        Integer peek = RL.peek();
        if (list == null || list.size() == 0) {
            RL.offer(RL.poll());
            return peek;
        } else if (list.size() > 4) {
            RL.offer(RL.poll());
            return peek;
        } else {
            int i = 0;
            while (true) {
                if (i >= RL.size()) {
                    i = 0;
                    break;
                }
                Integer num = RL.get(i);
                boolean z = false;
                for (Integer num2 : list) {
                    z = num2.intValue() == num.intValue() ? true : z;
                }
                if (!z) {
                    break;
                }
                i++;
            }
            Integer remove = RL.remove(i);
            RL.offer(remove);
            return remove;
        }
    }
}
