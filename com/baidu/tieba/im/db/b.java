package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b bxl = new b();

    public static b TU() {
        return bxl;
    }

    private b() {
    }

    public synchronized void TV() {
        com.baidu.tieba.im.settingcache.j.XA().TV();
        com.baidu.tieba.im.settingcache.h.Xz().TV();
        com.baidu.tieba.im.settingcache.c.Xx().TV();
    }
}
