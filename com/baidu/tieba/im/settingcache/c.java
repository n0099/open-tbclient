package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dTK;
    private boolean isAcceptNotify;

    public static c aCY() {
        if (dTK == null) {
            synchronized (c.class) {
                if (dTK == null) {
                    dTK = new c();
                }
            }
        }
        return dTK;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
