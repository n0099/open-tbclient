package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b kqn = new b();

    public static b cVM() {
        return kqn;
    }

    private b() {
    }

    public synchronized void cVN() {
        com.baidu.tieba.im.settingcache.e.cZZ().cVN();
        com.baidu.tieba.im.settingcache.d.cZY().cVN();
        com.baidu.tieba.im.settingcache.b.cZW().cVN();
    }
}
