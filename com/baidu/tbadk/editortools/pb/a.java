package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aDB;
    private int mStatus = 0;

    public static a Dz() {
        if (aDB == null) {
            synchronized (a.class) {
                if (aDB == null) {
                    aDB = new a();
                }
            }
        }
        return aDB;
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
