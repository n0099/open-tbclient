package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a dyd;
    private int mStatus = 0;

    public static a aON() {
        if (dyd == null) {
            synchronized (a.class) {
                if (dyd == null) {
                    dyd = new a();
                }
            }
        }
        return dyd;
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
