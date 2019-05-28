package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gJN;
    private boolean isAcceptNotify;

    public static c bDJ() {
        if (gJN == null) {
            synchronized (c.class) {
                if (gJN == null) {
                    gJN = new c();
                }
            }
        }
        return gJN;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
