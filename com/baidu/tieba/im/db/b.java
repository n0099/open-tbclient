package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b bfd = new b();

    public static b Rk() {
        return bfd;
    }

    private b() {
    }

    public synchronized void Rl() {
        com.baidu.tieba.im.settingcache.j.UQ().Rl();
        com.baidu.tieba.im.settingcache.h.UP().Rl();
        com.baidu.tieba.im.settingcache.c.UN().Rl();
    }
}
