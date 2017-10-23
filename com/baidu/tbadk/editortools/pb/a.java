package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aCh;
    private int mStatus = 0;

    public static a CP() {
        if (aCh == null) {
            synchronized (a.class) {
                if (aCh == null) {
                    aCh = new a();
                }
            }
        }
        return aCh;
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
