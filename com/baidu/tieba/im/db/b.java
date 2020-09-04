package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b jmc = new b();

    public static b cDV() {
        return jmc;
    }

    private b() {
    }

    public synchronized void cDW() {
        com.baidu.tieba.im.settingcache.e.cIl().cDW();
        com.baidu.tieba.im.settingcache.d.cIk().cDW();
        com.baidu.tieba.im.settingcache.b.cIi().cDW();
    }
}
