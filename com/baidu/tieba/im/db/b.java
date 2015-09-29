package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b bwD = new b();

    public static b TD() {
        return bwD;
    }

    private b() {
    }

    public synchronized void TE() {
        com.baidu.tieba.im.settingcache.j.Xj().TE();
        com.baidu.tieba.im.settingcache.h.Xi().TE();
        com.baidu.tieba.im.settingcache.c.Xg().TE();
    }
}
