package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bHE;
    private boolean isAcceptNotify;

    public static g Xd() {
        if (bHE == null) {
            synchronized (g.class) {
                if (bHE == null) {
                    bHE = new g();
                }
            }
        }
        return bHE;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
