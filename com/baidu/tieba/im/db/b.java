package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b eBx = new b();

    public static b aHX() {
        return eBx;
    }

    private b() {
    }

    public synchronized void aHY() {
        com.baidu.tieba.im.settingcache.e.aLX().aHY();
        com.baidu.tieba.im.settingcache.d.aLW().aHY();
        com.baidu.tieba.im.settingcache.b.aLU().aHY();
    }
}
