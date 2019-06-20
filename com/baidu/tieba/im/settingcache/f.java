package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gJW;
    private boolean isAcceptNotify;

    public static f bDN() {
        if (gJW == null) {
            synchronized (f.class) {
                if (gJW == null) {
                    gJW = new f();
                }
            }
        }
        return gJW;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
