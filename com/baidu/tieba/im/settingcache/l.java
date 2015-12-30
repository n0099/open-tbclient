package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l cbl;
    private boolean isAcceptNotify;

    public static l abP() {
        if (cbl == null) {
            synchronized (l.class) {
                if (cbl == null) {
                    cbl = new l();
                }
            }
        }
        return cbl;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
