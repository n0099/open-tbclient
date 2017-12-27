package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b evr = new b();

    public static b aGq() {
        return evr;
    }

    private b() {
    }

    public synchronized void aGr() {
        com.baidu.tieba.im.settingcache.e.aKl().aGr();
        com.baidu.tieba.im.settingcache.d.aKk().aGr();
        com.baidu.tieba.im.settingcache.b.aKi().aGr();
    }
}
