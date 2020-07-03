package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b iPT = new b();

    public static b cpx() {
        return iPT;
    }

    private b() {
    }

    public synchronized void cpy() {
        com.baidu.tieba.im.settingcache.e.ctq().cpy();
        com.baidu.tieba.im.settingcache.d.ctp().cpy();
        com.baidu.tieba.im.settingcache.b.ctn().cpy();
    }
}
