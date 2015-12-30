package com.baidu.tbadk.editortools.d;
/* loaded from: classes.dex */
public class b {
    private static b atV;
    private int mStatus = 0;

    public static b BK() {
        if (atV == null) {
            synchronized (b.class) {
                if (atV == null) {
                    atV = new b();
                }
            }
        }
        return atV;
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
