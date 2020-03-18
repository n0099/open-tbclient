package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c hLo;
    private boolean isAcceptNotify;

    public static c bYt() {
        if (hLo == null) {
            synchronized (c.class) {
                if (hLo == null) {
                    hLo = new c();
                }
            }
        }
        return hLo;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
