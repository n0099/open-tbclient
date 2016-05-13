package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g crg;
    private boolean isAcceptNotify;

    public static g aiu() {
        if (crg == null) {
            synchronized (g.class) {
                if (crg == null) {
                    crg = new g();
                }
            }
        }
        return crg;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
