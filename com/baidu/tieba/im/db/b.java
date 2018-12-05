package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b eNt = new b();

    public static b aQn() {
        return eNt;
    }

    private b() {
    }

    public synchronized void aQo() {
        com.baidu.tieba.im.settingcache.e.aUl().aQo();
        com.baidu.tieba.im.settingcache.d.aUk().aQo();
        com.baidu.tieba.im.settingcache.b.aUi().aQo();
    }
}
