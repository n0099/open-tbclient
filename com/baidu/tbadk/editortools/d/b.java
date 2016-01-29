package com.baidu.tbadk.editortools.d;
/* loaded from: classes.dex */
public class b {
    private static b auN;
    private int mStatus = 0;

    public static b Da() {
        if (auN == null) {
            synchronized (b.class) {
                if (auN == null) {
                    auN = new b();
                }
            }
        }
        return auN;
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
