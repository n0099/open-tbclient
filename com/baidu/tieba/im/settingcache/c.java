package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dLR;
    private boolean isAcceptNotify;

    public static c aBu() {
        if (dLR == null) {
            synchronized (c.class) {
                if (dLR == null) {
                    dLR = new c();
                }
            }
        }
        return dLR;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
