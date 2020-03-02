package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c hJC;
    private boolean isAcceptNotify;

    public static c bYa() {
        if (hJC == null) {
            synchronized (c.class) {
                if (hJC == null) {
                    hJC = new c();
                }
            }
        }
        return hJC;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
