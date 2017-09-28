package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dEr;
    private boolean isAcceptNotify;

    public static c aze() {
        if (dEr == null) {
            synchronized (c.class) {
                if (dEr == null) {
                    dEr = new c();
                }
            }
        }
        return dEr;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
