package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f iKK;
    private boolean isAcceptNotify;

    public static f cpC() {
        if (iKK == null) {
            synchronized (f.class) {
                if (iKK == null) {
                    iKK = new f();
                }
            }
        }
        return iKK;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
