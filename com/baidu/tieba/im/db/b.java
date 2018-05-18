package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dXj = new b();

    public static b aCU() {
        return dXj;
    }

    private b() {
    }

    public synchronized void aCV() {
        com.baidu.tieba.im.settingcache.e.aGV().aCV();
        com.baidu.tieba.im.settingcache.d.aGU().aCV();
        com.baidu.tieba.im.settingcache.b.aGS().aCV();
    }
}
