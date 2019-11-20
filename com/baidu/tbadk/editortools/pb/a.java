package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a cFT;
    private int mStatus = 0;

    public static a aut() {
        if (cFT == null) {
            synchronized (a.class) {
                if (cFT == null) {
                    cFT = new a();
                }
            }
        }
        return cFT;
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
