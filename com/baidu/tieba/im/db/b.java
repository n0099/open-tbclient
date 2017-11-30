package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public class b {
    private static b dIe = new b();

    public static b azg() {
        return dIe;
    }

    private b() {
    }

    public synchronized void azh() {
        com.baidu.tieba.im.settingcache.e.aDa().azh();
        com.baidu.tieba.im.settingcache.d.aCZ().azh();
        com.baidu.tieba.im.settingcache.b.aCX().azh();
    }
}
