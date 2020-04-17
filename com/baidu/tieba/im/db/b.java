package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b ijn = new b();

    public static b cfd() {
        return ijn;
    }

    private b() {
    }

    public synchronized void cfe() {
        com.baidu.tieba.im.settingcache.e.ciW().cfe();
        com.baidu.tieba.im.settingcache.d.ciV().cfe();
        com.baidu.tieba.im.settingcache.b.ciT().cfe();
    }
}
