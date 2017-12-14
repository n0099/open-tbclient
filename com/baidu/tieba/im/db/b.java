package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dJh = new b();

    public static b azp() {
        return dJh;
    }

    private b() {
    }

    public synchronized void azq() {
        com.baidu.tieba.im.settingcache.e.aDj().azq();
        com.baidu.tieba.im.settingcache.d.aDi().azq();
        com.baidu.tieba.im.settingcache.b.aDg().azq();
    }
}
