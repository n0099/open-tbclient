package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dJl = new b();

    public static b azp() {
        return dJl;
    }

    private b() {
    }

    public synchronized void azq() {
        com.baidu.tieba.im.settingcache.e.aDj().azq();
        com.baidu.tieba.im.settingcache.d.aDi().azq();
        com.baidu.tieba.im.settingcache.b.aDg().azq();
    }
}
