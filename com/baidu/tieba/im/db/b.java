package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b bfe = new b();

    public static b Rl() {
        return bfe;
    }

    private b() {
    }

    public synchronized void Rm() {
        com.baidu.tieba.im.settingcache.j.UR().Rm();
        com.baidu.tieba.im.settingcache.h.UQ().Rm();
        com.baidu.tieba.im.settingcache.c.UO().Rm();
    }
}
