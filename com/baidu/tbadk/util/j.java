package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
import java.util.LinkedHashMap;
import java.util.Random;
/* loaded from: classes.dex */
public class j {
    private static int cBA;
    private static LinkedHashMap<String, Integer> cBB;
    private static int cBy;
    private static final int[] cBz = {R.color.cp_atp_a, R.color.cp_atp_b, R.color.cp_atp_c, R.color.cp_atp_d, R.color.cp_atp_e};

    public static int qM(String str) {
        if (cBB == null) {
            cBB = new LinkedHashMap<>(20);
        }
        if (StringUtils.isNull(str)) {
            return cBz[0];
        }
        if (cBB.containsKey(str)) {
            return cBB.get(str).intValue();
        }
        int nextInt = new Random().nextInt(cBz.length);
        if (cBA != nextInt) {
            cBA = nextInt;
        } else {
            cBA = (cBA + 1) % cBz.length;
        }
        if (cBA < cBz.length) {
            cBy = cBz[cBA];
        }
        cBB.put(str, Integer.valueOf(cBy));
        return cBy;
    }
}
