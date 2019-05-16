package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gJT;
    private boolean isAcceptNotify;

    public static f bDJ() {
        if (gJT == null) {
            synchronized (f.class) {
                if (gJT == null) {
                    gJT = new f();
                }
            }
        }
        return gJT;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
