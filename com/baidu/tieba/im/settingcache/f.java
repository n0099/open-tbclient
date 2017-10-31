package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dLY;
    private boolean isAcceptNotify;

    public static f aBx() {
        if (dLY == null) {
            synchronized (f.class) {
                if (dLY == null) {
                    dLY = new f();
                }
            }
        }
        return dLY;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
