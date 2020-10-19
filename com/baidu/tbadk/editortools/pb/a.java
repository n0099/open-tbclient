package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a fbj;
    private int mStatus = 0;

    public static a bvI() {
        if (fbj == null) {
            synchronized (a.class) {
                if (fbj == null) {
                    fbj = new a();
                }
            }
        }
        return fbj;
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
