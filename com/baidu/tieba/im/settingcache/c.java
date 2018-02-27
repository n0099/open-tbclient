package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eMY;
    private boolean isAcceptNotify;

    public static c aLU() {
        if (eMY == null) {
            synchronized (c.class) {
                if (eMY == null) {
                    eMY = new c();
                }
            }
        }
        return eMY;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
