package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b kcJ = new b();

    public static b cQy() {
        return kcJ;
    }

    private b() {
    }

    public synchronized void cQz() {
        com.baidu.tieba.im.settingcache.e.cUN().cQz();
        com.baidu.tieba.im.settingcache.d.cUM().cQz();
        com.baidu.tieba.im.settingcache.b.cUK().cQz();
    }
}
