package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b ewP = new b();

    public static b aGv() {
        return ewP;
    }

    private b() {
    }

    public synchronized void aGw() {
        com.baidu.tieba.im.settingcache.e.aKq().aGw();
        com.baidu.tieba.im.settingcache.d.aKp().aGw();
        com.baidu.tieba.im.settingcache.b.aKn().aGw();
    }
}
