package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b cfi = new b();

    public static b aen() {
        return cfi;
    }

    private b() {
    }

    public synchronized void aeo() {
        com.baidu.tieba.im.settingcache.j.aiu().aeo();
        com.baidu.tieba.im.settingcache.h.ait().aeo();
        com.baidu.tieba.im.settingcache.c.air().aeo();
    }
}
