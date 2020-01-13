package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f hHI;
    private boolean isAcceptNotify;

    public static f bWA() {
        if (hHI == null) {
            synchronized (f.class) {
                if (hHI == null) {
                    hHI = new f();
                }
            }
        }
        return hHI;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
