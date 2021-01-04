package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b kBe = new b();

    public static b cXj() {
        return kBe;
    }

    private b() {
    }

    public synchronized void cXk() {
        com.baidu.tieba.im.settingcache.e.cZN().cXk();
        com.baidu.tieba.im.settingcache.d.cZM().cXk();
        com.baidu.tieba.im.settingcache.b.cZK().cXk();
    }
}
