package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a cuB;
    private int mStatus = 0;

    public static a asJ() {
        if (cuB == null) {
            synchronized (a.class) {
                if (cuB == null) {
                    cuB = new a();
                }
            }
        }
        return cuB;
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
