package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b kEF = new b();

    public static b cVq() {
        return kEF;
    }

    private b() {
    }

    public synchronized void cVr() {
        com.baidu.tieba.im.settingcache.e.cXU().cVr();
        com.baidu.tieba.im.settingcache.d.cXT().cVr();
        com.baidu.tieba.im.settingcache.b.cXR().cVr();
    }
}
