package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eNv;
    private boolean isAcceptNotify;

    public static f aLY() {
        if (eNv == null) {
            synchronized (f.class) {
                if (eNv == null) {
                    eNv = new f();
                }
            }
        }
        return eNv;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
