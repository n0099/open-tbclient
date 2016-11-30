package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dgi = new b();

    public static b auz() {
        return dgi;
    }

    private b() {
    }

    public synchronized void auA() {
        com.baidu.tieba.im.settingcache.j.ayG().auA();
        com.baidu.tieba.im.settingcache.h.ayF().auA();
        com.baidu.tieba.im.settingcache.c.ayD().auA();
    }
}
