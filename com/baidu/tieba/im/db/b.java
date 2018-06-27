package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b emp = new b();

    public static b aIw() {
        return emp;
    }

    private b() {
    }

    public synchronized void aIx() {
        com.baidu.tieba.im.settingcache.e.aMw().aIx();
        com.baidu.tieba.im.settingcache.d.aMv().aIx();
        com.baidu.tieba.im.settingcache.b.aMt().aIx();
    }
}
