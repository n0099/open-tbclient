package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eJk;
    private boolean isAcceptNotify;

    public static c aPG() {
        if (eJk == null) {
            synchronized (c.class) {
                if (eJk == null) {
                    eJk = new c();
                }
            }
        }
        return eJk;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
