package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dHo;
    private boolean isAcceptNotify;

    public static f aAj() {
        if (dHo == null) {
            synchronized (f.class) {
                if (dHo == null) {
                    dHo = new f();
                }
            }
        }
        return dHo;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
