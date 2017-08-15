package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dAL;
    private boolean isAcceptNotify;

    public static f ayz() {
        if (dAL == null) {
            synchronized (f.class) {
                if (dAL == null) {
                    dAL = new f();
                }
            }
        }
        return dAL;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
