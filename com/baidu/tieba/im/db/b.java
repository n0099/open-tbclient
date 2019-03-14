package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b ghb = new b();

    public static b bsf() {
        return ghb;
    }

    private b() {
    }

    public synchronized void bsg() {
        com.baidu.tieba.im.settingcache.e.bwd().bsg();
        com.baidu.tieba.im.settingcache.d.bwc().bsg();
        com.baidu.tieba.im.settingcache.b.bwa().bsg();
    }
}
