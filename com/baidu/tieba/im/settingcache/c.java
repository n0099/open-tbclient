package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c kpL;
    private boolean isAcceptNotify;

    public static c cUL() {
        if (kpL == null) {
            synchronized (c.class) {
                if (kpL == null) {
                    kpL = new c();
                }
            }
        }
        return kpL;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
