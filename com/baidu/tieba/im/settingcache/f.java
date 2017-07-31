package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dyO;
    private boolean isAcceptNotify;

    public static f axS() {
        if (dyO == null) {
            synchronized (f.class) {
                if (dyO == null) {
                    dyO = new f();
                }
            }
        }
        return dyO;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
