package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a baA;
    private int mStatus = 0;

    public static a ML() {
        if (baA == null) {
            synchronized (a.class) {
                if (baA == null) {
                    baA = new a();
                }
            }
        }
        return baA;
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
