package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s {
    public static int Zn;
    public static long Zo;
    public static long Zp;
    public static long Zq;
    public static int Zr;
    public static int Zs;
    public static long Zt;

    public static void uE() {
        com.baidu.adp.lib.stats.q logItem = q.getLogItem();
        logItem.n("action", "imcost");
        logItem.n("dect", String.valueOf(Zo));
        logItem.n("dlsize", String.valueOf(Zp));
        logItem.n("dbt", String.valueOf(Zq));
        logItem.n("pnum", String.valueOf(Zr));
        logItem.n("reqcost", String.valueOf(Zt));
        logItem.n("cpu", String.valueOf(Zs));
        logItem.n("totalNum", String.valueOf(Zn));
        com.baidu.adp.lib.stats.f.er().b("im", logItem);
        uM();
    }

    public static void uM() {
        Zn = 0;
        Zo = 0L;
        Zp = 0L;
        Zq = 0L;
        Zr = 0;
        Zs = 0;
    }
}
