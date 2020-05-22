package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b iyb = new b();

    public static b clz() {
        return iyb;
    }

    private b() {
    }

    public synchronized void clA() {
        com.baidu.tieba.im.settingcache.e.cps().clA();
        com.baidu.tieba.im.settingcache.d.cpr().clA();
        com.baidu.tieba.im.settingcache.b.cpp().clA();
    }
}
