package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b kbZ = new b();

    public static b cQS() {
        return kbZ;
    }

    private b() {
    }

    public synchronized void cQT() {
        com.baidu.tieba.im.settingcache.e.cVh().cQT();
        com.baidu.tieba.im.settingcache.d.cVg().cQT();
        com.baidu.tieba.im.settingcache.b.cVe().cQT();
    }
}
