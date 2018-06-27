package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eyn;
    private boolean isAcceptNotify;

    public static f aMx() {
        if (eyn == null) {
            synchronized (f.class) {
                if (eyn == null) {
                    eyn = new f();
                }
            }
        }
        return eyn;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
