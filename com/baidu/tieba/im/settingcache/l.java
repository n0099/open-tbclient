package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bnx;
    private boolean isAcceptNotify;

    public static l TE() {
        if (bnx == null) {
            synchronized (l.class) {
                if (bnx == null) {
                    bnx = new l();
                }
            }
        }
        return bnx;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
