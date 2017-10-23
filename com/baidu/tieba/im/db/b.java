package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dsh = new b();

    public static b auU() {
        return dsh;
    }

    private b() {
    }

    public synchronized void auV() {
        com.baidu.tieba.im.settingcache.e.azb().auV();
        com.baidu.tieba.im.settingcache.d.aza().auV();
        com.baidu.tieba.im.settingcache.b.ayY().auV();
    }
}
