package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a dYl;
    private int mStatus = 0;

    public static a aXl() {
        if (dYl == null) {
            synchronized (a.class) {
                if (dYl == null) {
                    dYl = new a();
                }
            }
        }
        return dYl;
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
