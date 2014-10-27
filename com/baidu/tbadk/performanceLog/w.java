package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends u {
    public static void a(long j, long j2, long j3) {
        if (v.uN().uO()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("procname", "main");
            logItem.n("atime", String.valueOf(j));
            logItem.n("logoctime", String.valueOf(j2));
            logItem.n("logoresutime", String.valueOf(j3));
            com.baidu.adp.lib.stats.f.er().b("startt", logItem);
        }
    }

    public static void t(long j) {
        if (v.uN().uO()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("procname", "remote");
            logItem.n("costt", String.valueOf(j));
            com.baidu.adp.lib.stats.f.er().b("startt", logItem);
        }
    }
}
