package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dxw;
    private boolean isAcceptNotify;

    public static f axH() {
        if (dxw == null) {
            synchronized (f.class) {
                if (dxw == null) {
                    dxw = new f();
                }
            }
        }
        return dxw;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
