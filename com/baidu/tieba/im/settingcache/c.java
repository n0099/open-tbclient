package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eup;
    private boolean isAcceptNotify;

    public static c aLO() {
        if (eup == null) {
            synchronized (c.class) {
                if (eup == null) {
                    eup = new c();
                }
            }
        }
        return eup;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
