package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f iJX;
    private boolean isAcceptNotify;

    public static f cpt() {
        if (iJX == null) {
            synchronized (f.class) {
                if (iJX == null) {
                    iJX = new f();
                }
            }
        }
        return iJX;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
