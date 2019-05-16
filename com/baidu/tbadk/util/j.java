package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
import java.util.LinkedHashMap;
import java.util.Random;
/* loaded from: classes.dex */
public class j {
    private static LinkedHashMap<String, Integer> cBA;
    private static int cBx;
    private static final int[] cBy = {R.color.cp_atp_a, R.color.cp_atp_b, R.color.cp_atp_c, R.color.cp_atp_d, R.color.cp_atp_e};
    private static int cBz;

    public static int qN(String str) {
        if (cBA == null) {
            cBA = new LinkedHashMap<>(20);
        }
        if (StringUtils.isNull(str)) {
            return cBy[0];
        }
        if (cBA.containsKey(str)) {
            return cBA.get(str).intValue();
        }
        int nextInt = new Random().nextInt(cBy.length);
        if (cBz != nextInt) {
            cBz = nextInt;
        } else {
            cBz = (cBz + 1) % cBy.length;
        }
        if (cBz < cBy.length) {
            cBx = cBy[cBz];
        }
        cBA.put(str, Integer.valueOf(cBx));
        return cBx;
    }
}
