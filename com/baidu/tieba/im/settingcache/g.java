package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bpW;
    private boolean isAcceptNotify;

    public static g UP() {
        if (bpW == null) {
            synchronized (g.class) {
                if (bpW == null) {
                    bpW = new g();
                }
            }
        }
        return bpW;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
