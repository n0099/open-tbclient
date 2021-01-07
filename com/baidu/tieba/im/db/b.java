package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b kBe = new b();

    public static b cXk() {
        return kBe;
    }

    private b() {
    }

    public synchronized void cXl() {
        com.baidu.tieba.im.settingcache.e.cZO().cXl();
        com.baidu.tieba.im.settingcache.d.cZN().cXl();
        com.baidu.tieba.im.settingcache.b.cZL().cXl();
    }
}
