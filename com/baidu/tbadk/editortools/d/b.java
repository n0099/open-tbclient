package com.baidu.tbadk.editortools.d;
/* loaded from: classes.dex */
public class b {
    private static b arm;
    private int mStatus = 0;

    public static b BC() {
        if (arm == null) {
            synchronized (b.class) {
                if (arm == null) {
                    arm = new b();
                }
            }
        }
        return arm;
    }

    private b() {
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }
}
