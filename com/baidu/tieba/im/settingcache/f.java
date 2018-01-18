package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eIH;
    private boolean isAcceptNotify;

    public static f aKr() {
        if (eIH == null) {
            synchronized (f.class) {
                if (eIH == null) {
                    eIH = new f();
                }
            }
        }
        return eIH;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
