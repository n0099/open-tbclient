package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bqc;
    private boolean isAcceptNotify;

    public static l UR() {
        if (bqc == null) {
            synchronized (l.class) {
                if (bqc == null) {
                    bqc = new l();
                }
            }
        }
        return bqc;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
