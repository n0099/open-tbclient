package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gJU;
    private boolean isAcceptNotify;

    public static f bDM() {
        if (gJU == null) {
            synchronized (f.class) {
                if (gJU == null) {
                    gJU = new f();
                }
            }
        }
        return gJU;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
