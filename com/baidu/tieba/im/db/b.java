package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dsu = new b();

    public static b auZ() {
        return dsu;
    }

    private b() {
    }

    public synchronized void ava() {
        com.baidu.tieba.im.settingcache.e.azg().ava();
        com.baidu.tieba.im.settingcache.d.azf().ava();
        com.baidu.tieba.im.settingcache.b.azd().ava();
    }
}
