package com.baidu.tbadk.coreExtra.data;

import android.content.Context;
/* loaded from: classes.dex */
public class a {
    private final int ajt;
    private final int aju;
    private final boolean ajv;
    private final Context mContext;

    public a(Context context, int i, int i2, boolean z) {
        this.mContext = context;
        this.ajt = i;
        this.aju = i2;
        this.ajv = z;
    }

    public a(Context context, int i, int i2) {
        this(context, i, i2, false);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int xU() {
        return this.ajt;
    }

    public int xV() {
        return this.aju;
    }

    public boolean xW() {
        return this.ajv;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.ajt > 0 && this.aju > 0;
    }
}
