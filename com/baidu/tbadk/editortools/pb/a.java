package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a btR;
    private int mStatus = 0;

    public static a Ly() {
        if (btR == null) {
            synchronized (a.class) {
                if (btR == null) {
                    btR = new a();
                }
            }
        }
        return btR;
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
