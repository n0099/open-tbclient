package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aQX;
    private int mStatus = 0;

    public static a Jf() {
        if (aQX == null) {
            synchronized (a.class) {
                if (aQX == null) {
                    aQX = new a();
                }
            }
        }
        return aQX;
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
