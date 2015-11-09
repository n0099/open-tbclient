package com.baidu.tbadk.editortools.c;
/* loaded from: classes.dex */
public class b {
    private static b aqn;
    private int mStatus = 0;

    public static b AW() {
        if (aqn == null) {
            synchronized (b.class) {
                if (aqn == null) {
                    aqn = new b();
                }
            }
        }
        return aqn;
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
