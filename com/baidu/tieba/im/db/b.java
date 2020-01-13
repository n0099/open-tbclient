package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b hvM = new b();

    public static b bSG() {
        return hvM;
    }

    private b() {
    }

    public synchronized void bSH() {
        com.baidu.tieba.im.settingcache.e.bWz().bSH();
        com.baidu.tieba.im.settingcache.d.bWy().bSH();
        com.baidu.tieba.im.settingcache.b.bWw().bSH();
    }
}
