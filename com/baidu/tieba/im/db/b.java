package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b ijt = new b();

    public static b cfb() {
        return ijt;
    }

    private b() {
    }

    public synchronized void cfc() {
        com.baidu.tieba.im.settingcache.e.ciU().cfc();
        com.baidu.tieba.im.settingcache.d.ciT().cfc();
        com.baidu.tieba.im.settingcache.b.ciR().cfc();
    }
}
