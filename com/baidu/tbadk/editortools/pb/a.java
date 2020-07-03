package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a evp;
    private int mStatus = 0;

    public static a bfx() {
        if (evp == null) {
            synchronized (a.class) {
                if (evp == null) {
                    evp = new a();
                }
            }
        }
        return evp;
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
