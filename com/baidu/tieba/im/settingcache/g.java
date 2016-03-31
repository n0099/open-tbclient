package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g cqj;
    private boolean isAcceptNotify;

    public static g ail() {
        if (cqj == null) {
            synchronized (g.class) {
                if (cqj == null) {
                    cqj = new g();
                }
            }
        }
        return cqj;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
