package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eSt;
    private boolean isAcceptNotify;

    public static f aSu() {
        if (eSt == null) {
            synchronized (f.class) {
                if (eSt == null) {
                    eSt = new f();
                }
            }
        }
        return eSt;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
