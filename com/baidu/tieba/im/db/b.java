package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b exk = new b();

    public static b aGA() {
        return exk;
    }

    private b() {
    }

    public synchronized void aGB() {
        com.baidu.tieba.im.settingcache.e.aKv().aGB();
        com.baidu.tieba.im.settingcache.d.aKu().aGB();
        com.baidu.tieba.im.settingcache.b.aKs().aGB();
    }
}
