package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.d;
import java.util.LinkedHashMap;
import java.util.Random;
/* loaded from: classes.dex */
public class j {
    private static int ctl;
    private static final int[] ctm = {d.C0277d.cp_atp_a, d.C0277d.cp_atp_b, d.C0277d.cp_atp_c, d.C0277d.cp_atp_d, d.C0277d.cp_atp_e};
    private static int ctn;
    private static LinkedHashMap<String, Integer> cto;

    public static int pD(String str) {
        if (cto == null) {
            cto = new LinkedHashMap<>(20);
        }
        if (StringUtils.isNull(str)) {
            return ctm[0];
        }
        if (cto.containsKey(str)) {
            return cto.get(str).intValue();
        }
        int nextInt = new Random().nextInt(ctm.length);
        if (ctn != nextInt) {
            ctn = nextInt;
        } else {
            ctn = (ctn + 1) % ctm.length;
        }
        if (ctn < ctm.length) {
            ctl = ctm[ctn];
        }
        cto.put(str, Integer.valueOf(ctl));
        return ctl;
    }
}
