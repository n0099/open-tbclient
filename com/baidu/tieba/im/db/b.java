package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b eNt = new b();

    public static b aQm() {
        return eNt;
    }

    private b() {
    }

    public synchronized void aQn() {
        com.baidu.tieba.im.settingcache.e.aUk().aQn();
        com.baidu.tieba.im.settingcache.d.aUj().aQn();
        com.baidu.tieba.im.settingcache.b.aUh().aQn();
    }
}
