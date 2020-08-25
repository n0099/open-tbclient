package com.baidu.tieba.im.db;
/* loaded from: classes2.dex */
public class b {
    private static b jlW = new b();

    public static b cDU() {
        return jlW;
    }

    private b() {
    }

    public synchronized void cDV() {
        com.baidu.tieba.im.settingcache.e.cIk().cDV();
        com.baidu.tieba.im.settingcache.d.cIj().cDV();
        com.baidu.tieba.im.settingcache.b.cIh().cDV();
    }
}
