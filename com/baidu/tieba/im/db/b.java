package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b hxZ = new b();

    public static b bUk() {
        return hxZ;
    }

    private b() {
    }

    public synchronized void bUl() {
        com.baidu.tieba.im.settingcache.e.bYd().bUl();
        com.baidu.tieba.im.settingcache.d.bYc().bUl();
        com.baidu.tieba.im.settingcache.b.bYa().bUl();
    }
}
