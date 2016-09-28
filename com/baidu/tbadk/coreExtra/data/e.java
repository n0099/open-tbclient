package com.baidu.tbadk.coreExtra.data;

import android.content.Context;
/* loaded from: classes.dex */
public class e {
    private final int aju;
    private final int ajv;
    private final boolean ajw;
    private final Context mContext;

    public e(Context context, int i, int i2, boolean z) {
        this.mContext = context;
        this.aju = i;
        this.ajv = i2;
        this.ajw = z;
    }

    public e(Context context, int i, int i2) {
        this(context, i, i2, false);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int xG() {
        return this.aju;
    }

    public int xH() {
        return this.ajv;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.aju > 0 && this.ajv > 0;
    }
}
