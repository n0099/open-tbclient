package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
import java.util.LinkedHashMap;
import java.util.Random;
/* loaded from: classes.dex */
public class j {
    private static int cCW;
    private static final int[] cCX = {R.color.cp_atp_a, R.color.cp_atp_b, R.color.cp_atp_c, R.color.cp_atp_d, R.color.cp_atp_e};
    private static int cCY;
    private static LinkedHashMap<String, Integer> cCZ;

    public static int rd(String str) {
        if (cCZ == null) {
            cCZ = new LinkedHashMap<>(20);
        }
        if (StringUtils.isNull(str)) {
            return cCX[0];
        }
        if (cCZ.containsKey(str)) {
            return cCZ.get(str).intValue();
        }
        int nextInt = new Random().nextInt(cCX.length);
        if (cCY != nextInt) {
            cCY = nextInt;
        } else {
            cCY = (cCY + 1) % cCX.length;
        }
        if (cCY < cCX.length) {
            cCW = cCX[cCY];
        }
        cCZ.put(str, Integer.valueOf(cCW));
        return cCW;
    }
}
