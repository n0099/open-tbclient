package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bXf;
    private boolean isAcceptNotify;

    public static g aaE() {
        if (bXf == null) {
            synchronized (g.class) {
                if (bXf == null) {
                    bXf = new g();
                }
            }
        }
        return bXf;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
