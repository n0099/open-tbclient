package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bEq;
    private boolean isAcceptNotify;

    public static g Wy() {
        if (bEq == null) {
            synchronized (g.class) {
                if (bEq == null) {
                    bEq = new g();
                }
            }
        }
        return bEq;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
