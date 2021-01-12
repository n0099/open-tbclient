package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b kwz = new b();

    public static b cTs() {
        return kwz;
    }

    private b() {
    }

    public synchronized void cTt() {
        com.baidu.tieba.im.settingcache.e.cVW().cTt();
        com.baidu.tieba.im.settingcache.d.cVV().cTt();
        com.baidu.tieba.im.settingcache.b.cVT().cTt();
    }
}
