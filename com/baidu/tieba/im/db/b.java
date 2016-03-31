package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b ceC = new b();

    public static b aen() {
        return ceC;
    }

    private b() {
    }

    public synchronized void aeo() {
        com.baidu.tieba.im.settingcache.j.ain().aeo();
        com.baidu.tieba.im.settingcache.h.aim().aeo();
        com.baidu.tieba.im.settingcache.c.aik().aeo();
    }
}
