package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l crn;
    private boolean isAcceptNotify;

    public static l aiv() {
        if (crn == null) {
            synchronized (l.class) {
                if (crn == null) {
                    crn = new l();
                }
            }
        }
        return crn;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
