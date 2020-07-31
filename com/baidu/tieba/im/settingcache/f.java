package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f jkg;
    private boolean isAcceptNotify;

    public static f cxu() {
        if (jkg == null) {
            synchronized (f.class) {
                if (jkg == null) {
                    jkg = new f();
                }
            }
        }
        return jkg;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
