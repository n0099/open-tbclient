package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s {
    public static int Zr;
    public static long Zs;
    public static long Zt;
    public static long Zu;
    public static int Zv;
    public static int Zw;
    public static long Zx;

    public static void uG() {
        com.baidu.adp.lib.stats.q logItem = q.getLogItem();
        logItem.n("action", "imcost");
        logItem.n("dect", String.valueOf(Zs));
        logItem.n("dlsize", String.valueOf(Zt));
        logItem.n("dbt", String.valueOf(Zu));
        logItem.n("pnum", String.valueOf(Zv));
        logItem.n("reqcost", String.valueOf(Zx));
        logItem.n("cpu", String.valueOf(Zw));
        logItem.n("totalNum", String.valueOf(Zr));
        com.baidu.adp.lib.stats.f.er().b("im", logItem);
        uO();
    }

    public static void uO() {
        Zr = 0;
        Zs = 0L;
        Zt = 0L;
        Zu = 0L;
        Zv = 0;
        Zw = 0;
    }
}
