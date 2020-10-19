package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c jWF;
    private boolean isAcceptNotify;

    public static c cPx() {
        if (jWF == null) {
            synchronized (c.class) {
                if (jWF == null) {
                    jWF = new c();
                }
            }
        }
        return jWF;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
