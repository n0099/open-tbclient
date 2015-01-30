package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bpd;
    private boolean isAcceptNotify;

    public static g Ts() {
        if (bpd == null) {
            synchronized (g.class) {
                if (bpd == null) {
                    bpd = new g();
                }
            }
        }
        return bpd;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
