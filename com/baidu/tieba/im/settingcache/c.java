package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c kjf;
    private boolean isAcceptNotify;

    public static c cSE() {
        if (kjf == null) {
            synchronized (c.class) {
                if (kjf == null) {
                    kjf = new c();
                }
            }
        }
        return kjf;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
