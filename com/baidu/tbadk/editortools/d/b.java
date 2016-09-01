package com.baidu.tbadk.editortools.d;
/* loaded from: classes.dex */
public class b {
    private static b avY;
    private int mStatus = 0;

    public static b Dh() {
        if (avY == null) {
            synchronized (b.class) {
                if (avY == null) {
                    avY = new b();
                }
            }
        }
        return avY;
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
