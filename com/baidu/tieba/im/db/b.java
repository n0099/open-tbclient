package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b cKC = new b();

    public static b amE() {
        return cKC;
    }

    private b() {
    }

    public synchronized void amF() {
        com.baidu.tieba.im.settingcache.j.aqK().amF();
        com.baidu.tieba.im.settingcache.h.aqJ().amF();
        com.baidu.tieba.im.settingcache.c.aqH().amF();
    }
}
