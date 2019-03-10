package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b ghc = new b();

    public static b bsg() {
        return ghc;
    }

    private b() {
    }

    public synchronized void bsh() {
        com.baidu.tieba.im.settingcache.e.bwe().bsh();
        com.baidu.tieba.im.settingcache.d.bwd().bsh();
        com.baidu.tieba.im.settingcache.b.bwb().bsh();
    }
}
