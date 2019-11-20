package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b gEg = new b();

    public static b bAh() {
        return gEg;
    }

    private b() {
    }

    public synchronized void bAi() {
        com.baidu.tieba.im.settingcache.e.bEe().bAi();
        com.baidu.tieba.im.settingcache.d.bEd().bAi();
        com.baidu.tieba.im.settingcache.b.bEb().bAi();
    }
}
