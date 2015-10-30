package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b bwO = new b();

    public static b Tz() {
        return bwO;
    }

    private b() {
    }

    public synchronized void TA() {
        com.baidu.tieba.im.settingcache.j.Xf().TA();
        com.baidu.tieba.im.settingcache.h.Xe().TA();
        com.baidu.tieba.im.settingcache.c.Xc().TA();
    }
}
