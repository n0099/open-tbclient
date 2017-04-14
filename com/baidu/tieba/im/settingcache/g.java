package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g dfc;
    private boolean isAcceptNotify;

    public static g atx() {
        if (dfc == null) {
            synchronized (g.class) {
                if (dfc == null) {
                    dfc = new g();
                }
            }
        }
        return dfc;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
