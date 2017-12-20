package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dUP;
    private boolean isAcceptNotify;

    public static c aDg() {
        if (dUP == null) {
            synchronized (c.class) {
                if (dUP == null) {
                    dUP = new c();
                }
            }
        }
        return dUP;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
