package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b bsU = new b();

    public static b ST() {
        return bsU;
    }

    private b() {
    }

    public synchronized void SU() {
        com.baidu.tieba.im.settingcache.j.Wy().SU();
        com.baidu.tieba.im.settingcache.h.Wx().SU();
        com.baidu.tieba.im.settingcache.c.Wv().SU();
    }
}
