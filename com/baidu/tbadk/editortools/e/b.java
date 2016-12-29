package com.baidu.tbadk.editortools.e;
/* loaded from: classes.dex */
public class b {
    private static b avS;
    private int mStatus = 0;

    public static b CY() {
        if (avS == null) {
            synchronized (b.class) {
                if (avS == null) {
                    avS = new b();
                }
            }
        }
        return avS;
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
