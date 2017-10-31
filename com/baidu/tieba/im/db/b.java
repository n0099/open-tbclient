package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dzW = new b();

    public static b axp() {
        return dzW;
    }

    private b() {
    }

    public synchronized void axq() {
        com.baidu.tieba.im.settingcache.e.aBw().axq();
        com.baidu.tieba.im.settingcache.d.aBv().axq();
        com.baidu.tieba.im.settingcache.b.aBt().axq();
    }
}
