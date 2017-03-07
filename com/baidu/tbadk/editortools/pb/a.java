package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aAs;
    private int mStatus = 0;

    public static a Dm() {
        if (aAs == null) {
            synchronized (a.class) {
                if (aAs == null) {
                    aAs = new a();
                }
            }
        }
        return aAs;
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
