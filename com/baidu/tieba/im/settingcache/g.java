package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bpV;
    private boolean isAcceptNotify;

    public static g UO() {
        if (bpV == null) {
            synchronized (g.class) {
                if (bpV == null) {
                    bpV = new g();
                }
            }
        }
        return bpV;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
