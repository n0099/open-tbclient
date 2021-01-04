package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a fFS;
    private int mStatus = 0;

    public static a bFl() {
        if (fFS == null) {
            synchronized (a.class) {
                if (fFS == null) {
                    fFS = new a();
                }
            }
        }
        return fFS;
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
