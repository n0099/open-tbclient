package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f hJH;
    private boolean isAcceptNotify;

    public static f bYb() {
        if (hJH == null) {
            synchronized (f.class) {
                if (hJH == null) {
                    hJH = new f();
                }
            }
        }
        return hJH;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
