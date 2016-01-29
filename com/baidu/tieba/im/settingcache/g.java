package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g cfE;
    private boolean isAcceptNotify;

    public static g aeS() {
        if (cfE == null) {
            synchronized (g.class) {
                if (cfE == null) {
                    cfE = new g();
                }
            }
        }
        return cfE;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
