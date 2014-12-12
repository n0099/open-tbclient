package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bnG;
    private boolean isAcceptNotify;

    public static g SW() {
        if (bnG == null) {
            synchronized (g.class) {
                if (bnG == null) {
                    bnG = new g();
                }
            }
        }
        return bnG;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
