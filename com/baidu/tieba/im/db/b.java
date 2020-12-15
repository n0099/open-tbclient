package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b kqp = new b();

    public static b cVN() {
        return kqp;
    }

    private b() {
    }

    public synchronized void cVO() {
        com.baidu.tieba.im.settingcache.e.daa().cVO();
        com.baidu.tieba.im.settingcache.d.cZZ().cVO();
        com.baidu.tieba.im.settingcache.b.cZX().cVO();
    }
}
