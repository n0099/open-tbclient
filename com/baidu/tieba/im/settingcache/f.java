package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gsS;
    private boolean isAcceptNotify;

    public static f bwe() {
        if (gsS == null) {
            synchronized (f.class) {
                if (gsS == null) {
                    gsS = new f();
                }
            }
        }
        return gsS;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
