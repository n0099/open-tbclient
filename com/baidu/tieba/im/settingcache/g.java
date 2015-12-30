package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g cbe;
    private boolean isAcceptNotify;

    public static g abM() {
        if (cbe == null) {
            synchronized (g.class) {
                if (cbe == null) {
                    cbe = new g();
                }
            }
        }
        return cbe;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
