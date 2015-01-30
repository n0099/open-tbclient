package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b aYc = new b();

    public static b MO() {
        return aYc;
    }

    private b() {
    }

    public synchronized void MP() {
        com.baidu.tieba.im.settingcache.j.Tu().MP();
        com.baidu.tieba.im.settingcache.h.Tt().MP();
        com.baidu.tieba.im.settingcache.c.Tr().MP();
    }
}
