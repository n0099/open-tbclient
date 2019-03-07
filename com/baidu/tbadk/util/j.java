package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
import java.util.LinkedHashMap;
import java.util.Random;
/* loaded from: classes.dex */
public class j {
    private static int cto;
    private static final int[] ctp = {d.C0236d.cp_atp_a, d.C0236d.cp_atp_b, d.C0236d.cp_atp_c, d.C0236d.cp_atp_d, d.C0236d.cp_atp_e};
    private static int ctq;
    private static LinkedHashMap<String, Integer> ctr;

    public static int pE(String str) {
        if (ctr == null) {
            ctr = new LinkedHashMap<>(20);
        }
        if (StringUtils.isNull(str)) {
            return ctp[0];
        }
        if (ctr.containsKey(str)) {
            return ctr.get(str).intValue();
        }
        int nextInt = new Random().nextInt(ctp.length);
        if (ctq != nextInt) {
            ctq = nextInt;
        } else {
            ctq = (ctq + 1) % ctp.length;
        }
        if (ctq < ctp.length) {
            cto = ctp[ctq];
        }
        ctr.put(str, Integer.valueOf(cto));
        return cto;
    }
}
