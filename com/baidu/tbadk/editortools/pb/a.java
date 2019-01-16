package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a baz;
    private int mStatus = 0;

    public static a ML() {
        if (baz == null) {
            synchronized (a.class) {
                if (baz == null) {
                    baz = new a();
                }
            }
        }
        return baz;
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
