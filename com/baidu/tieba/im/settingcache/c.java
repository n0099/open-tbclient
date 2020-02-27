package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c hJA;
    private boolean isAcceptNotify;

    public static c bXY() {
        if (hJA == null) {
            synchronized (c.class) {
                if (hJA == null) {
                    hJA = new c();
                }
            }
        }
        return hJA;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
