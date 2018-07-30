package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b eqi = new b();

    public static b aJx() {
        return eqi;
    }

    private b() {
    }

    public synchronized void aJy() {
        com.baidu.tieba.im.settingcache.e.aNw().aJy();
        com.baidu.tieba.im.settingcache.d.aNv().aJy();
        com.baidu.tieba.im.settingcache.b.aNt().aJy();
    }
}
