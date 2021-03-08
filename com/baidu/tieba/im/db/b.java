package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b kGV = new b();

    public static b cVE() {
        return kGV;
    }

    private b() {
    }

    public synchronized void cVF() {
        com.baidu.tieba.im.settingcache.e.cYi().cVF();
        com.baidu.tieba.im.settingcache.d.cYh().cVF();
        com.baidu.tieba.im.settingcache.b.cYf().cVF();
    }
}
