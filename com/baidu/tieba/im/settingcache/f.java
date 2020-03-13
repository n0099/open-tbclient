package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f hJV;
    private boolean isAcceptNotify;

    public static f bYe() {
        if (hJV == null) {
            synchronized (f.class) {
                if (hJV == null) {
                    hJV = new f();
                }
            }
        }
        return hJV;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
