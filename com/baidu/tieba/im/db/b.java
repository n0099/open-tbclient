package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b cfi = new b();

    public static b aep() {
        return cfi;
    }

    private b() {
    }

    public synchronized void aeq() {
        com.baidu.tieba.im.settingcache.j.aiw().aeq();
        com.baidu.tieba.im.settingcache.h.aiv().aeq();
        com.baidu.tieba.im.settingcache.c.ait().aeq();
    }
}
