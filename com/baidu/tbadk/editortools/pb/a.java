package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a dyr;
    private int mStatus = 0;

    public static a aOQ() {
        if (dyr == null) {
            synchronized (a.class) {
                if (dyr == null) {
                    dyr = new a();
                }
            }
        }
        return dyr;
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
