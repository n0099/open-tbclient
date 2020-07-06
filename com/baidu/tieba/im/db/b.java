package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b iPT = new b();

    public static b cpy() {
        return iPT;
    }

    private b() {
    }

    public synchronized void cpz() {
        com.baidu.tieba.im.settingcache.e.ctr().cpz();
        com.baidu.tieba.im.settingcache.d.ctq().cpz();
        com.baidu.tieba.im.settingcache.b.cto().cpz();
    }
}
