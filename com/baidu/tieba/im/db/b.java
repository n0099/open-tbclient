package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b hxL = new b();

    public static b bUh() {
        return hxL;
    }

    private b() {
    }

    public synchronized void bUi() {
        com.baidu.tieba.im.settingcache.e.bYa().bUi();
        com.baidu.tieba.im.settingcache.d.bXZ().bUi();
        com.baidu.tieba.im.settingcache.b.bXX().bUi();
    }
}
