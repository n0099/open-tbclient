package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b eQW = new b();

    public static b aRA() {
        return eQW;
    }

    private b() {
    }

    public synchronized void aRB() {
        com.baidu.tieba.im.settingcache.e.aVy().aRB();
        com.baidu.tieba.im.settingcache.d.aVx().aRB();
        com.baidu.tieba.im.settingcache.b.aVv().aRB();
    }
}
