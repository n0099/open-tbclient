package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bIg;
    private boolean isAcceptNotify;

    public static l XB() {
        if (bIg == null) {
            synchronized (l.class) {
                if (bIg == null) {
                    bIg = new l();
                }
            }
        }
        return bIg;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
