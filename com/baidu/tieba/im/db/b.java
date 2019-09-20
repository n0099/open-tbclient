package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b gGZ = new b();

    public static b bDz() {
        return gGZ;
    }

    private b() {
    }

    public synchronized void bDA() {
        com.baidu.tieba.im.settingcache.e.bHv().bDA();
        com.baidu.tieba.im.settingcache.d.bHu().bDA();
        com.baidu.tieba.im.settingcache.b.bHs().bDA();
    }
}
