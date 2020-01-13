package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a dtX;
    private int mStatus = 0;

    public static a aMr() {
        if (dtX == null) {
            synchronized (a.class) {
                if (dtX == null) {
                    dtX = new a();
                }
            }
        }
        return dtX;
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
