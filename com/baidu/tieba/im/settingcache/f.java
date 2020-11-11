package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f kpi;
    private boolean isAcceptNotify;

    public static f cVi() {
        if (kpi == null) {
            synchronized (f.class) {
                if (kpi == null) {
                    kpi = new f();
                }
            }
        }
        return kpi;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
