package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b gFh = new b();

    public static b bCL() {
        return gFh;
    }

    private b() {
    }

    public synchronized void bCM() {
        com.baidu.tieba.im.settingcache.e.bGH().bCM();
        com.baidu.tieba.im.settingcache.d.bGG().bCM();
        com.baidu.tieba.im.settingcache.b.bGE().bCM();
    }
}
