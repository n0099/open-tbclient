package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gsT;
    private boolean isAcceptNotify;

    public static f bwf() {
        if (gsT == null) {
            synchronized (f.class) {
                if (gsT == null) {
                    gsT = new f();
                }
            }
        }
        return gsT;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
