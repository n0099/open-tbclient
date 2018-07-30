package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aNI;
    private int mStatus = 0;

    public static a HP() {
        if (aNI == null) {
            synchronized (a.class) {
                if (aNI == null) {
                    aNI = new a();
                }
            }
        }
        return aNI;
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
