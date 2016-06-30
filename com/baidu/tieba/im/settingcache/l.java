package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l cWD;
    private boolean isAcceptNotify;

    public static l aqL() {
        if (cWD == null) {
            synchronized (l.class) {
                if (cWD == null) {
                    cWD = new l();
                }
            }
        }
        return cWD;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
