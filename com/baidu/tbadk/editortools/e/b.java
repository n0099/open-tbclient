package com.baidu.tbadk.editortools.e;
/* loaded from: classes.dex */
public class b {
    private static b avB;
    private int mStatus = 0;

    public static b Dh() {
        if (avB == null) {
            synchronized (b.class) {
                if (avB == null) {
                    avB = new b();
                }
            }
        }
        return avB;
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
