package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b bPX = new b();

    public static b Yg() {
        return bPX;
    }

    private b() {
    }

    public synchronized void Yh() {
        com.baidu.tieba.im.settingcache.j.abO().Yh();
        com.baidu.tieba.im.settingcache.h.abN().Yh();
        com.baidu.tieba.im.settingcache.c.abL().Yh();
    }
}
