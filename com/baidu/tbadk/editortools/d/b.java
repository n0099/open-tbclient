package com.baidu.tbadk.editortools.d;
/* loaded from: classes.dex */
public class b {
    private static b asc;
    private int mStatus = 0;

    public static b BM() {
        if (asc == null) {
            synchronized (b.class) {
                if (asc == null) {
                    asc = new b();
                }
            }
        }
        return asc;
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
