package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b ggP = new b();

    public static b bsc() {
        return ggP;
    }

    private b() {
    }

    public synchronized void bsd() {
        com.baidu.tieba.im.settingcache.e.bwa().bsd();
        com.baidu.tieba.im.settingcache.d.bvZ().bsd();
        com.baidu.tieba.im.settingcache.b.bvX().bsd();
    }
}
