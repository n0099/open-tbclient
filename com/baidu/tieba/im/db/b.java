package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b btA = new b();

    public static b SV() {
        return btA;
    }

    private b() {
    }

    public synchronized void SW() {
        com.baidu.tieba.im.settingcache.j.WA().SW();
        com.baidu.tieba.im.settingcache.h.Wz().SW();
        com.baidu.tieba.im.settingcache.c.Wx().SW();
    }
}
