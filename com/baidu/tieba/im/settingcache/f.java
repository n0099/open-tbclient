package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f ehY;
    private boolean isAcceptNotify;

    public static f aGY() {
        if (ehY == null) {
            synchronized (f.class) {
                if (ehY == null) {
                    ehY = new f();
                }
            }
        }
        return ehY;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
