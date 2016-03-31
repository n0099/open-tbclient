package com.baidu.tbadk.editortools.d;
/* loaded from: classes.dex */
public class b {
    private static b avn;
    private int mStatus = 0;

    public static b DI() {
        if (avn == null) {
            synchronized (b.class) {
                if (avn == null) {
                    avn = new b();
                }
            }
        }
        return avn;
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
