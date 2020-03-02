package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f hJJ;
    private boolean isAcceptNotify;

    public static f bYd() {
        if (hJJ == null) {
            synchronized (f.class) {
                if (hJJ == null) {
                    hJJ = new f();
                }
            }
        }
        return hJJ;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
