package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eHa;
    private boolean isAcceptNotify;

    public static c aKj() {
        if (eHa == null) {
            synchronized (c.class) {
                if (eHa == null) {
                    eHa = new c();
                }
            }
        }
        return eHa;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
