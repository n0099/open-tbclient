package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b eQk = new b();

    public static b aRa() {
        return eQk;
    }

    private b() {
    }

    public synchronized void aRb() {
        com.baidu.tieba.im.settingcache.e.aUY().aRb();
        com.baidu.tieba.im.settingcache.d.aUX().aRb();
        com.baidu.tieba.im.settingcache.b.aUV().aRb();
    }
}
