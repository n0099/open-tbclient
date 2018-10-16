package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b eFk = new b();

    public static b aOY() {
        return eFk;
    }

    private b() {
    }

    public synchronized void aOZ() {
        com.baidu.tieba.im.settingcache.e.aSW().aOZ();
        com.baidu.tieba.im.settingcache.d.aSV().aOZ();
        com.baidu.tieba.im.settingcache.b.aST().aOZ();
    }
}
