package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g cZr;
    private boolean isAcceptNotify;

    public static g aru() {
        if (cZr == null) {
            synchronized (g.class) {
                if (cZr == null) {
                    cZr = new g();
                }
            }
        }
        return cZr;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
