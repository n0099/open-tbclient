package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.R;
import java.util.LinkedHashMap;
import java.util.Random;
/* loaded from: classes.dex */
public class j {
    private static int cCP;
    private static final int[] cCQ = {R.color.cp_atp_a, R.color.cp_atp_b, R.color.cp_atp_c, R.color.cp_atp_d, R.color.cp_atp_e};
    private static int cCR;
    private static LinkedHashMap<String, Integer> cCS;

    public static int rd(String str) {
        if (cCS == null) {
            cCS = new LinkedHashMap<>(20);
        }
        if (StringUtils.isNull(str)) {
            return cCQ[0];
        }
        if (cCS.containsKey(str)) {
            return cCS.get(str).intValue();
        }
        int nextInt = new Random().nextInt(cCQ.length);
        if (cCR != nextInt) {
            cCR = nextInt;
        } else {
            cCR = (cCR + 1) % cCQ.length;
        }
        if (cCR < cCQ.length) {
            cCP = cCQ[cCR];
        }
        cCS.put(str, Integer.valueOf(cCP));
        return cCP;
    }
}
