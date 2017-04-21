package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b cVp = new b();

    public static b aqt() {
        return cVp;
    }

    private b() {
    }

    public synchronized void aqu() {
        com.baidu.tieba.im.settingcache.j.auA().aqu();
        com.baidu.tieba.im.settingcache.h.auz().aqu();
        com.baidu.tieba.im.settingcache.c.aux().aqu();
    }
}
