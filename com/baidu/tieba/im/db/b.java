package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b cSl = new b();

    public static b aqf() {
        return cSl;
    }

    private b() {
    }

    public synchronized void aqg() {
        com.baidu.tieba.im.settingcache.j.aul().aqg();
        com.baidu.tieba.im.settingcache.h.auk().aqg();
        com.baidu.tieba.im.settingcache.c.aui().aqg();
    }
}
