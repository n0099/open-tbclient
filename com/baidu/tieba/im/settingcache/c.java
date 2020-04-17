package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c ive;
    private boolean isAcceptNotify;

    public static c ciU() {
        if (ive == null) {
            synchronized (c.class) {
                if (ive == null) {
                    ive = new c();
                }
            }
        }
        return ive;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
