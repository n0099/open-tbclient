package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eNf;
    private boolean isAcceptNotify;

    public static f aLX() {
        if (eNf == null) {
            synchronized (f.class) {
                if (eNf == null) {
                    eNf = new f();
                }
            }
        }
        return eNf;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
