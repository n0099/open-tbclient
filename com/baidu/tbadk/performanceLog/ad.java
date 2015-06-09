package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad {
    public static int aqP;
    public static long aqQ;
    public static long aqR;
    public static long aqS;
    public static int aqT;
    public static int aqU;
    public static long aqV;

    public static void Dp() {
        com.baidu.adp.lib.stats.q hm = ab.hm();
        hm.r("action", "imcost");
        hm.r("dect", String.valueOf(aqQ));
        hm.r("dlsize", String.valueOf(aqR));
        hm.r("dbt", String.valueOf(aqS));
        hm.r("pnum", String.valueOf(aqT));
        hm.r("reqcost", String.valueOf(aqV));
        hm.r("cpu", String.valueOf(aqU));
        hm.r("totalNum", String.valueOf(aqP));
        com.baidu.adp.lib.stats.f.hz().b("im", hm);
        DB();
    }

    public static void DB() {
        aqP = 0;
        aqQ = 0L;
        aqR = 0L;
        aqS = 0L;
        aqT = 0;
        aqU = 0;
    }
}
