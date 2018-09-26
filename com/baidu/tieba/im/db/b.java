package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b exy = new b();

    public static b aLJ() {
        return exy;
    }

    private b() {
    }

    public synchronized void aLK() {
        com.baidu.tieba.im.settingcache.e.aPI().aLK();
        com.baidu.tieba.im.settingcache.d.aPH().aLK();
        com.baidu.tieba.im.settingcache.b.aPF().aLK();
    }
}
