package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b bMr = new b();

    public static b Xa() {
        return bMr;
    }

    private b() {
    }

    public synchronized void Xb() {
        com.baidu.tieba.im.settingcache.j.aaG().Xb();
        com.baidu.tieba.im.settingcache.h.aaF().Xb();
        com.baidu.tieba.im.settingcache.c.aaD().Xb();
    }
}
