package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f jzn;
    private boolean isAcceptNotify;

    public static f cIm() {
        if (jzn == null) {
            synchronized (f.class) {
                if (jzn == null) {
                    jzn = new f();
                }
            }
        }
        return jzn;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
