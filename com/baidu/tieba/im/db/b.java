package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b doH = new b();

    public static b aur() {
        return doH;
    }

    private b() {
    }

    public synchronized void aus() {
        com.baidu.tieba.im.settingcache.e.ayt().aus();
        com.baidu.tieba.im.settingcache.d.ays().aus();
        com.baidu.tieba.im.settingcache.b.ayq().aus();
    }
}
