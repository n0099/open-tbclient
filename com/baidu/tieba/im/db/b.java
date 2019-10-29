package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b gEX = new b();

    public static b bAj() {
        return gEX;
    }

    private b() {
    }

    public synchronized void bAk() {
        com.baidu.tieba.im.settingcache.e.bEg().bAk();
        com.baidu.tieba.im.settingcache.d.bEf().bAk();
        com.baidu.tieba.im.settingcache.b.bEd().bAk();
    }
}
