package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b eqe = new b();

    public static b aJu() {
        return eqe;
    }

    private b() {
    }

    public synchronized void aJv() {
        com.baidu.tieba.im.settingcache.e.aNt().aJv();
        com.baidu.tieba.im.settingcache.d.aNs().aJv();
        com.baidu.tieba.im.settingcache.b.aNq().aJv();
    }
}
