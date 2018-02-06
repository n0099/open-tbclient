package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eNr;
    private boolean isAcceptNotify;

    public static f aLY() {
        if (eNr == null) {
            synchronized (f.class) {
                if (eNr == null) {
                    eNr = new f();
                }
            }
        }
        return eNr;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
