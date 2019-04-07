package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
import java.util.LinkedHashMap;
import java.util.Random;
/* loaded from: classes.dex */
public class j {
    private static int ctn;
    private static final int[] cto = {d.C0277d.cp_atp_a, d.C0277d.cp_atp_b, d.C0277d.cp_atp_c, d.C0277d.cp_atp_d, d.C0277d.cp_atp_e};
    private static int ctp;
    private static LinkedHashMap<String, Integer> ctq;

    public static int pE(String str) {
        if (ctq == null) {
            ctq = new LinkedHashMap<>(20);
        }
        if (StringUtils.isNull(str)) {
            return cto[0];
        }
        if (ctq.containsKey(str)) {
            return ctq.get(str).intValue();
        }
        int nextInt = new Random().nextInt(cto.length);
        if (ctp != nextInt) {
            ctp = nextInt;
        } else {
            ctp = (ctp + 1) % cto.length;
        }
        if (ctp < cto.length) {
            ctn = cto[ctp];
        }
        ctq.put(str, Integer.valueOf(ctn));
        return ctn;
    }
}
