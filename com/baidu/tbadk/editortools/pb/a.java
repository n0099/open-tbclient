package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aBx;
    private int mStatus = 0;

    public static a Dc() {
        if (aBx == null) {
            synchronized (a.class) {
                if (aBx == null) {
                    aBx = new a();
                }
            }
        }
        return aBx;
    }

    private a() {
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }
}
