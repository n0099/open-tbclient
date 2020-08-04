package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b iWY = new b();

    public static b ctd() {
        return iWY;
    }

    private b() {
    }

    public synchronized void cte() {
        com.baidu.tieba.im.settingcache.e.cxt().cte();
        com.baidu.tieba.im.settingcache.d.cxs().cte();
        com.baidu.tieba.im.settingcache.b.cxq().cte();
    }
}
