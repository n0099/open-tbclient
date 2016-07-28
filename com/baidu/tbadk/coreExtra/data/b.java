package com.baidu.tbadk.coreExtra.data;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private final int agN;
    private final int agO;
    private final boolean agP;
    private final Context mContext;

    public b(Context context, int i, int i2, boolean z) {
        this.mContext = context;
        this.agN = i;
        this.agO = i2;
        this.agP = z;
    }

    public b(Context context, int i, int i2) {
        this(context, i, i2, false);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int ws() {
        return this.agN;
    }

    public int wt() {
        return this.agO;
    }

    public boolean wu() {
        return this.agP;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.agN > 0 && this.agO > 0;
    }
}
