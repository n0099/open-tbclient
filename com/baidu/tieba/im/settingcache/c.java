package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dLW;
    private boolean isAcceptNotify;

    public static c aBy() {
        if (dLW == null) {
            synchronized (c.class) {
                if (dLW == null) {
                    dLW = new c();
                }
            }
        }
        return dLW;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
