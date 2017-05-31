package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g dgR;
    private boolean isAcceptNotify;

    public static g asq() {
        if (dgR == null) {
            synchronized (g.class) {
                if (dgR == null) {
                    dgR = new g();
                }
            }
        }
        return dgR;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
