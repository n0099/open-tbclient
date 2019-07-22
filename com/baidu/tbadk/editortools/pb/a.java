package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a ctx;
    private int mStatus = 0;

    public static a asv() {
        if (ctx == null) {
            synchronized (a.class) {
                if (ctx == null) {
                    ctx = new a();
                }
            }
        }
        return ctx;
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
