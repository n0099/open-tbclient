package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f fcN;
    private boolean isAcceptNotify;

    public static f aVz() {
        if (fcN == null) {
            synchronized (f.class) {
                if (fcN == null) {
                    fcN = new f();
                }
            }
        }
        return fcN;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
