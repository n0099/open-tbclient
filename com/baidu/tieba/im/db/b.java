package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b aYb = new b();

    public static b MJ() {
        return aYb;
    }

    private b() {
    }

    public synchronized void MK() {
        com.baidu.tieba.im.settingcache.j.Tp().MK();
        com.baidu.tieba.im.settingcache.h.To().MK();
        com.baidu.tieba.im.settingcache.c.Tm().MK();
    }
}
