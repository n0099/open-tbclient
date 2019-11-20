package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gPU;
    private boolean isAcceptNotify;

    public static c bEc() {
        if (gPU == null) {
            synchronized (c.class) {
                if (gPU == null) {
                    gPU = new c();
                }
            }
        }
        return gPU;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
