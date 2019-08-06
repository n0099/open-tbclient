package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gQR;
    private boolean isAcceptNotify;

    public static c bGF() {
        if (gQR == null) {
            synchronized (c.class) {
                if (gQR == null) {
                    gQR = new c();
                }
            }
        }
        return gQR;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
