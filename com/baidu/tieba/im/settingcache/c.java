package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dAE;
    private boolean isAcceptNotify;

    public static c ayr() {
        if (dAE == null) {
            synchronized (c.class) {
                if (dAE == null) {
                    dAE = new c();
                }
            }
        }
        return dAE;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
