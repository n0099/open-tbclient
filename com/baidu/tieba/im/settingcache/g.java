package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bna;
    private boolean isAcceptNotify;

    public static g To() {
        if (bna == null) {
            synchronized (g.class) {
                if (bna == null) {
                    bna = new g();
                }
            }
        }
        return bna;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
