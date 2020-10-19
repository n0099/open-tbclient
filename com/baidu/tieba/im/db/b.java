package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b jJD = new b();

    public static b cLk() {
        return jJD;
    }

    private b() {
    }

    public synchronized void cLl() {
        com.baidu.tieba.im.settingcache.e.cPz().cLl();
        com.baidu.tieba.im.settingcache.d.cPy().cLl();
        com.baidu.tieba.im.settingcache.b.cPw().cLl();
    }
}
