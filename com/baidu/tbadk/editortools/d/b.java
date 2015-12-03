package com.baidu.tbadk.editortools.d;
/* loaded from: classes.dex */
public class b {
    private static b asr;
    private int mStatus = 0;

    public static b BV() {
        if (asr == null) {
            synchronized (b.class) {
                if (asr == null) {
                    asr = new b();
                }
            }
        }
        return asr;
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
