package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c ehR;
    private boolean isAcceptNotify;

    public static c aGV() {
        if (ehR == null) {
            synchronized (c.class) {
                if (ehR == null) {
                    ehR = new c();
                }
            }
        }
        return ehR;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
