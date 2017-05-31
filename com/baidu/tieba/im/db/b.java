package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b cUP = new b();

    public static b aom() {
        return cUP;
    }

    private b() {
    }

    public synchronized void aon() {
        com.baidu.tieba.im.settingcache.j.ass().aon();
        com.baidu.tieba.im.settingcache.h.asr().aon();
        com.baidu.tieba.im.settingcache.c.asp().aon();
    }
}
