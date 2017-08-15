package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b doH = new b();

    public static b auw() {
        return doH;
    }

    private b() {
    }

    public synchronized void aux() {
        com.baidu.tieba.im.settingcache.e.ayy().aux();
        com.baidu.tieba.im.settingcache.d.ayx().aux();
        com.baidu.tieba.im.settingcache.b.ayv().aux();
    }
}
