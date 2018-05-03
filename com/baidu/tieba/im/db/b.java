package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dWc = new b();

    public static b aCW() {
        return dWc;
    }

    private b() {
    }

    public synchronized void aCX() {
        com.baidu.tieba.im.settingcache.e.aGX().aCX();
        com.baidu.tieba.im.settingcache.d.aGW().aCX();
        com.baidu.tieba.im.settingcache.b.aGU().aCX();
    }
}
