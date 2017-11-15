package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dAq = new b();

    public static b axG() {
        return dAq;
    }

    private b() {
    }

    public synchronized void axH() {
        com.baidu.tieba.im.settingcache.e.aBA().axH();
        com.baidu.tieba.im.settingcache.d.aBz().axH();
        com.baidu.tieba.im.settingcache.b.aBx().axH();
    }
}
