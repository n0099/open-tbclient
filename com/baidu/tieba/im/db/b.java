package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b hxN = new b();

    public static b bUj() {
        return hxN;
    }

    private b() {
    }

    public synchronized void bUk() {
        com.baidu.tieba.im.settingcache.e.bYc().bUk();
        com.baidu.tieba.im.settingcache.d.bYb().bUk();
        com.baidu.tieba.im.settingcache.b.bXZ().bUk();
    }
}
