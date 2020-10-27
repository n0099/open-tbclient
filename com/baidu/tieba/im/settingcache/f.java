package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f kjm;
    private boolean isAcceptNotify;

    public static f cSH() {
        if (kjm == null) {
            synchronized (f.class) {
                if (kjm == null) {
                    kjm = new f();
                }
            }
        }
        return kjm;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
