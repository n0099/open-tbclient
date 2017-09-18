package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dIj;
    private boolean isAcceptNotify;

    public static f aAu() {
        if (dIj == null) {
            synchronized (f.class) {
                if (dIj == null) {
                    dIj = new f();
                }
            }
        }
        return dIj;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
