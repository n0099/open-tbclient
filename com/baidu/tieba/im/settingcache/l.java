package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l dsn;
    private boolean isAcceptNotify;

    public static l ayH() {
        if (dsn == null) {
            synchronized (l.class) {
                if (dsn == null) {
                    dsn = new l();
                }
            }
        }
        return dsn;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
