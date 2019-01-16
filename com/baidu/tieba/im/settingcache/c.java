package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c fcF;
    private boolean isAcceptNotify;

    public static c aVw() {
        if (fcF == null) {
            synchronized (c.class) {
                if (fcF == null) {
                    fcF = new c();
                }
            }
        }
        return fcF;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
