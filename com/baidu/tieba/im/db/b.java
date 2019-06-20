package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b gye = new b();

    public static b bzS() {
        return gye;
    }

    private b() {
    }

    public synchronized void bzT() {
        com.baidu.tieba.im.settingcache.e.bDM().bzT();
        com.baidu.tieba.im.settingcache.d.bDL().bzT();
        com.baidu.tieba.im.settingcache.b.bDJ().bzT();
    }
}
