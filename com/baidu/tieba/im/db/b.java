package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b eBB = new b();

    public static b aHX() {
        return eBB;
    }

    private b() {
    }

    public synchronized void aHY() {
        com.baidu.tieba.im.settingcache.e.aLX().aHY();
        com.baidu.tieba.im.settingcache.d.aLW().aHY();
        com.baidu.tieba.im.settingcache.b.aLU().aHY();
    }
}
