package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gQY;
    private boolean isAcceptNotify;

    public static f bGI() {
        if (gQY == null) {
            synchronized (f.class) {
                if (gQY == null) {
                    gQY = new f();
                }
            }
        }
        return gQY;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
