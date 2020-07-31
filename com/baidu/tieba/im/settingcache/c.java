package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c jjZ;
    private boolean isAcceptNotify;

    public static c cxr() {
        if (jjZ == null) {
            synchronized (c.class) {
                if (jjZ == null) {
                    jjZ = new c();
                }
            }
        }
        return jjZ;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
