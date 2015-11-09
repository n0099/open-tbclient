package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bHZ;
    private boolean isAcceptNotify;

    public static g Xy() {
        if (bHZ == null) {
            synchronized (g.class) {
                if (bHZ == null) {
                    bHZ = new g();
                }
            }
        }
        return bHZ;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
