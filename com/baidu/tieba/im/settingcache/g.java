package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bHt;
    private boolean isAcceptNotify;

    public static g Xh() {
        if (bHt == null) {
            synchronized (g.class) {
                if (bHt == null) {
                    bHt = new g();
                }
            }
        }
        return bHt;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
