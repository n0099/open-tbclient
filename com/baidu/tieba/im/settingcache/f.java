package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gSS;
    private boolean isAcceptNotify;

    public static f bHw() {
        if (gSS == null) {
            synchronized (f.class) {
                if (gSS == null) {
                    gSS = new f();
                }
            }
        }
        return gSS;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
