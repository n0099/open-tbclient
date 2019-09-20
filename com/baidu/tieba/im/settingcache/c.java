package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gSL;
    private boolean isAcceptNotify;

    public static c bHt() {
        if (gSL == null) {
            synchronized (c.class) {
                if (gSL == null) {
                    gSL = new c();
                }
            }
        }
        return gSL;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
