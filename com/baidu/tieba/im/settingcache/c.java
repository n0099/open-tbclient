package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eQU;
    private boolean isAcceptNotify;

    public static c aSU() {
        if (eQU == null) {
            synchronized (c.class) {
                if (eQU == null) {
                    eQU = new c();
                }
            }
        }
        return eQU;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
