package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eQT;
    private boolean isAcceptNotify;

    public static c aSU() {
        if (eQT == null) {
            synchronized (c.class) {
                if (eQT == null) {
                    eQT = new c();
                }
            }
        }
        return eQT;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
