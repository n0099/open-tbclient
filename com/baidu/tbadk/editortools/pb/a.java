package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a fwm;
    private int mStatus = 0;

    public static a bCQ() {
        if (fwm == null) {
            synchronized (a.class) {
                if (fwm == null) {
                    fwm = new a();
                }
            }
        }
        return fwm;
    }

    private a() {
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }
}
