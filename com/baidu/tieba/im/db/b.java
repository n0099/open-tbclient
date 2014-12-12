package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b aWG = new b();

    public static b Ms() {
        return aWG;
    }

    private b() {
    }

    public synchronized void Mt() {
        com.baidu.tieba.im.settingcache.j.SY().Mt();
        com.baidu.tieba.im.settingcache.h.SX().Mt();
        com.baidu.tieba.im.settingcache.c.SV().Mt();
    }
}
