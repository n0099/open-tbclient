package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aEr;
    private int mStatus = 0;

    public static a DZ() {
        if (aEr == null) {
            synchronized (a.class) {
                if (aEr == null) {
                    aEr = new a();
                }
            }
        }
        return aEr;
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
