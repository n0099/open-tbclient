package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bnq;
    private boolean isAcceptNotify;

    public static g TB() {
        if (bnq == null) {
            synchronized (g.class) {
                if (bnq == null) {
                    bnq = new g();
                }
            }
        }
        return bnq;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
