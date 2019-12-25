package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b hsj = new b();

    public static b bRx() {
        return hsj;
    }

    private b() {
    }

    public synchronized void bRy() {
        com.baidu.tieba.im.settingcache.e.bVq().bRy();
        com.baidu.tieba.im.settingcache.d.bVp().bRy();
        com.baidu.tieba.im.settingcache.b.bVn().bRy();
    }
}
