package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g doN;
    private boolean isAcceptNotify;

    public static g awb() {
        if (doN == null) {
            synchronized (g.class) {
                if (doN == null) {
                    doN = new g();
                }
            }
        }
        return doN;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
