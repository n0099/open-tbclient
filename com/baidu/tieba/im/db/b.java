package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b cLd = new b();

    public static b aoY() {
        return cLd;
    }

    private b() {
    }

    public synchronized void aoZ() {
        com.baidu.tieba.im.settingcache.j.atf().aoZ();
        com.baidu.tieba.im.settingcache.h.ate().aoZ();
        com.baidu.tieba.im.settingcache.c.atc().aoZ();
    }
}
