package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b bTZ = new b();

    public static b aaR() {
        return bTZ;
    }

    private b() {
    }

    public synchronized void aaS() {
        com.baidu.tieba.im.settingcache.j.aeU().aaS();
        com.baidu.tieba.im.settingcache.h.aeT().aaS();
        com.baidu.tieba.im.settingcache.c.aeR().aaS();
    }
}
