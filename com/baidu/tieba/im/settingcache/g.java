package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g cXa;
    private boolean isAcceptNotify;

    public static g atd() {
        if (cXa == null) {
            synchronized (g.class) {
                if (cXa == null) {
                    cXa = new g();
                }
            }
        }
        return cXa;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
