package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b gyc = new b();

    public static b bzR() {
        return gyc;
    }

    private b() {
    }

    public synchronized void bzS() {
        com.baidu.tieba.im.settingcache.e.bDL().bzS();
        com.baidu.tieba.im.settingcache.d.bDK().bzS();
        com.baidu.tieba.im.settingcache.b.bDI().bzS();
    }
}
