package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b eBl = new b();

    public static b aHW() {
        return eBl;
    }

    private b() {
    }

    public synchronized void aHX() {
        com.baidu.tieba.im.settingcache.e.aLW().aHX();
        com.baidu.tieba.im.settingcache.d.aLV().aHX();
        com.baidu.tieba.im.settingcache.b.aLT().aHX();
    }
}
