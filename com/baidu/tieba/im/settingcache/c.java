package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eIV;
    private boolean isAcceptNotify;

    public static c aKt() {
        if (eIV == null) {
            synchronized (c.class) {
                if (eIV == null) {
                    eIV = new c();
                }
            }
        }
        return eIV;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
