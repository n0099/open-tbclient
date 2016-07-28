package com.baidu.tbadk.editortools.d;
/* loaded from: classes.dex */
public class b {
    private static b asR;
    private int mStatus = 0;

    public static b BM() {
        if (asR == null) {
            synchronized (b.class) {
                if (asR == null) {
                    asR = new b();
                }
            }
        }
        return asR;
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
