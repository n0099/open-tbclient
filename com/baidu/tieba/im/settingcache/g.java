package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g dgF;
    private boolean isAcceptNotify;

    public static g atE() {
        if (dgF == null) {
            synchronized (g.class) {
                if (dgF == null) {
                    dgF = new g();
                }
            }
        }
        return dgF;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
