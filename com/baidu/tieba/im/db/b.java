package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dmJ = new b();

    public static b atP() {
        return dmJ;
    }

    private b() {
    }

    public synchronized void atQ() {
        com.baidu.tieba.im.settingcache.e.axR().atQ();
        com.baidu.tieba.im.settingcache.d.axQ().atQ();
        com.baidu.tieba.im.settingcache.b.axO().atQ();
    }
}
