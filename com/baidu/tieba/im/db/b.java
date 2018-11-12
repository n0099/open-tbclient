package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b eGE = new b();

    public static b aOv() {
        return eGE;
    }

    private b() {
    }

    public synchronized void aOw() {
        com.baidu.tieba.im.settingcache.e.aSt().aOw();
        com.baidu.tieba.im.settingcache.d.aSs().aOw();
        com.baidu.tieba.im.settingcache.b.aSq().aOw();
    }
}
