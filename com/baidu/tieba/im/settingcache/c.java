package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gPZ;
    private boolean isAcceptNotify;

    public static c bGr() {
        if (gPZ == null) {
            synchronized (c.class) {
                if (gPZ == null) {
                    gPZ = new c();
                }
            }
        }
        return gPZ;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
