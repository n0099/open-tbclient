package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b juG = new b();

    public static b cHB() {
        return juG;
    }

    private b() {
    }

    public synchronized void cHC() {
        com.baidu.tieba.im.settingcache.e.cLR().cHC();
        com.baidu.tieba.im.settingcache.d.cLQ().cHC();
        com.baidu.tieba.im.settingcache.b.cLO().cHC();
    }
}
