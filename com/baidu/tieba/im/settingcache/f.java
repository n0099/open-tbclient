package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f hEf;
    private boolean isAcceptNotify;

    public static f bVr() {
        if (hEf == null) {
            synchronized (f.class) {
                if (hEf == null) {
                    hEf = new f();
                }
            }
        }
        return hEf;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
