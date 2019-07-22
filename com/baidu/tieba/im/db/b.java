package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b gEp = new b();

    public static b bCx() {
        return gEp;
    }

    private b() {
    }

    public synchronized void bCy() {
        com.baidu.tieba.im.settingcache.e.bGt().bCy();
        com.baidu.tieba.im.settingcache.d.bGs().bCy();
        com.baidu.tieba.im.settingcache.b.bGq().bCy();
    }
}
