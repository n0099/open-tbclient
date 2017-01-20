package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g den;
    private boolean isAcceptNotify;

    public static g auj() {
        if (den == null) {
            synchronized (g.class) {
                if (den == null) {
                    den = new g();
                }
            }
        }
        return den;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
