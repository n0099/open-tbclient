package com.baidu.tbadk.editortools.e;
/* loaded from: classes.dex */
public class b {
    private static b awv;
    private int mStatus = 0;

    public static b Dp() {
        if (awv == null) {
            synchronized (b.class) {
                if (awv == null) {
                    awv = new b();
                }
            }
        }
        return awv;
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
