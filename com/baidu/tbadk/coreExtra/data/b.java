package com.baidu.tbadk.coreExtra.data;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private final int afY;
    private final int afZ;
    private final boolean aga;
    private final Context mContext;

    public b(Context context, int i, int i2, boolean z) {
        this.mContext = context;
        this.afY = i;
        this.afZ = i2;
        this.aga = z;
    }

    public b(Context context, int i, int i2) {
        this(context, i, i2, false);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int ws() {
        return this.afY;
    }

    public int wt() {
        return this.afZ;
    }

    public boolean wu() {
        return this.aga;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.afY > 0 && this.afZ > 0;
    }
}
