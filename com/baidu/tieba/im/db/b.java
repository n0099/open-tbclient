package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b cPr = new b();

    public static b anm() {
        return cPr;
    }

    private b() {
    }

    public synchronized void ann() {
        com.baidu.tieba.im.settingcache.j.aru().ann();
        com.baidu.tieba.im.settingcache.h.art().ann();
        com.baidu.tieba.im.settingcache.c.arr().ann();
    }
}
