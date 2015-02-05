package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bpc;
    private boolean isAcceptNotify;

    public static g Tn() {
        if (bpc == null) {
            synchronized (g.class) {
                if (bpc == null) {
                    bpc = new g();
                }
            }
        }
        return bpc;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
