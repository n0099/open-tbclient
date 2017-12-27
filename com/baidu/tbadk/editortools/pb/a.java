package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a brv;
    private int mStatus = 0;

    public static a La() {
        if (brv == null) {
            synchronized (a.class) {
                if (brv == null) {
                    brv = new a();
                }
            }
        }
        return brv;
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
