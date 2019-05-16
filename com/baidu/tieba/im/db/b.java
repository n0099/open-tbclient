package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b gyb = new b();

    public static b bzO() {
        return gyb;
    }

    private b() {
    }

    public synchronized void bzP() {
        com.baidu.tieba.im.settingcache.e.bDI().bzP();
        com.baidu.tieba.im.settingcache.d.bDH().bzP();
        com.baidu.tieba.im.settingcache.b.bDF().bzP();
    }
}
