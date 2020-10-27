package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b jWc = new b();

    public static b cOr() {
        return jWc;
    }

    private b() {
    }

    public synchronized void cOs() {
        com.baidu.tieba.im.settingcache.e.cSG().cOs();
        com.baidu.tieba.im.settingcache.d.cSF().cOs();
        com.baidu.tieba.im.settingcache.b.cSD().cOs();
    }
}
