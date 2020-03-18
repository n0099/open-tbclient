package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b hzz = new b();

    public static b bUC() {
        return hzz;
    }

    private b() {
    }

    public synchronized void bUD() {
        com.baidu.tieba.im.settingcache.e.bYv().bUD();
        com.baidu.tieba.im.settingcache.d.bYu().bUD();
        com.baidu.tieba.im.settingcache.b.bYs().bUD();
    }
}
