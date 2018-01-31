package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eJc;
    private boolean isAcceptNotify;

    public static f aKw() {
        if (eJc == null) {
            synchronized (f.class) {
                if (eJc == null) {
                    eJc = new f();
                }
            }
        }
        return eJc;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
