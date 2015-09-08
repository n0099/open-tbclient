package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bEx;
    private boolean isAcceptNotify;

    public static l WB() {
        if (bEx == null) {
            synchronized (l.class) {
                if (bEx == null) {
                    bEx = new l();
                }
            }
        }
        return bEx;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
