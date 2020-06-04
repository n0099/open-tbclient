package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b iyO = new b();

    public static b clI() {
        return iyO;
    }

    private b() {
    }

    public synchronized void clJ() {
        com.baidu.tieba.im.settingcache.e.cpB().clJ();
        com.baidu.tieba.im.settingcache.d.cpA().clJ();
        com.baidu.tieba.im.settingcache.b.cpy().clJ();
    }
}
