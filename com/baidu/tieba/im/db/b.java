package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b ijt = new b();

    public static b cfc() {
        return ijt;
    }

    private b() {
    }

    public synchronized void cfd() {
        com.baidu.tieba.im.settingcache.e.ciV().cfd();
        com.baidu.tieba.im.settingcache.d.ciU().cfd();
        com.baidu.tieba.im.settingcache.b.ciS().cfd();
    }
}
