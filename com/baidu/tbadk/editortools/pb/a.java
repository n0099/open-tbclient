package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aCx;
    private int mStatus = 0;

    public static a Do() {
        if (aCx == null) {
            synchronized (a.class) {
                if (aCx == null) {
                    aCx = new a();
                }
            }
        }
        return aCx;
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
