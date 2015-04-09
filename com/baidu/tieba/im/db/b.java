package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b bcz = new b();

    public static b PV() {
        return bcz;
    }

    private b() {
    }

    public synchronized void PW() {
        com.baidu.tieba.im.settingcache.j.TD().PW();
        com.baidu.tieba.im.settingcache.h.TC().PW();
        com.baidu.tieba.im.settingcache.c.TA().PW();
    }
}
