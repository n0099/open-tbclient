package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g cWw;
    private boolean isAcceptNotify;

    public static g aqI() {
        if (cWw == null) {
            synchronized (g.class) {
                if (cWw == null) {
                    cWw = new g();
                }
            }
        }
        return cWw;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
