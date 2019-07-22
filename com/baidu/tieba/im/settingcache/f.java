package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gQg;
    private boolean isAcceptNotify;

    public static f bGu() {
        if (gQg == null) {
            synchronized (f.class) {
                if (gQg == null) {
                    gQg = new f();
                }
            }
        }
        return gQg;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
