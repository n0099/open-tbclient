package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l dbB;
    private boolean isAcceptNotify;

    public static l arv() {
        if (dbB == null) {
            synchronized (l.class) {
                if (dbB == null) {
                    dbB = new l();
                }
            }
        }
        return dbB;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
