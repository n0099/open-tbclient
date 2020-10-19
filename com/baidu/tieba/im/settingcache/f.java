package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f jWM;
    private boolean isAcceptNotify;

    public static f cPA() {
        if (jWM == null) {
            synchronized (f.class) {
                if (jWM == null) {
                    jWM = new f();
                }
            }
        }
        return jWM;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
