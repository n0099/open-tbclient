package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eZi;
    private boolean isAcceptNotify;

    public static f aUm() {
        if (eZi == null) {
            synchronized (f.class) {
                if (eZi == null) {
                    eZi = new f();
                }
            }
        }
        return eZi;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
