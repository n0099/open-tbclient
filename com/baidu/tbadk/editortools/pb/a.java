package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a fjI;
    private int mStatus = 0;

    public static a bxB() {
        if (fjI == null) {
            synchronized (a.class) {
                if (fjI == null) {
                    fjI = new a();
                }
            }
        }
        return fjI;
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
