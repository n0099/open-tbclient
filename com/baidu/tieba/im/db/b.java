package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b bcj = new b();

    public static b PI() {
        return bcj;
    }

    private b() {
    }

    public synchronized void PJ() {
        com.baidu.tieba.im.settingcache.j.Tq().PJ();
        com.baidu.tieba.im.settingcache.h.Tp().PJ();
        com.baidu.tieba.im.settingcache.c.Tn().PJ();
    }
}
