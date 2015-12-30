package com.baidu.tbadk.coreExtra.data;

import android.content.Context;
/* loaded from: classes.dex */
public class a {
    private final int aiG;
    private final int aiH;
    private final boolean aiI;
    private final Context mContext;

    public a(Context context, int i, int i2, boolean z) {
        this.mContext = context;
        this.aiG = i;
        this.aiH = i2;
        this.aiI = z;
    }

    public a(Context context, int i, int i2) {
        this(context, i, i2, false);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int wG() {
        return this.aiG;
    }

    public int wH() {
        return this.aiH;
    }

    public boolean wI() {
        return this.aiI;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aiG > 0 && this.aiH > 0;
    }
}
