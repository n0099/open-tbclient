package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f jbM;
    private boolean isAcceptNotify;

    public static f ctr() {
        if (jbM == null) {
            synchronized (f.class) {
                if (jbM == null) {
                    jbM = new f();
                }
            }
        }
        return jbM;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
