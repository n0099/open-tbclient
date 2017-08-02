package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dlr = new b();

    public static b atD() {
        return dlr;
    }

    private b() {
    }

    public synchronized void atE() {
        com.baidu.tieba.im.settingcache.e.axG().atE();
        com.baidu.tieba.im.settingcache.d.axF().atE();
        com.baidu.tieba.im.settingcache.b.axD().atE();
    }
}
