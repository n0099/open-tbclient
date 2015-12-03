package com.baidu.tbadk.coreExtra.data;

import android.content.Context;
/* loaded from: classes.dex */
public class a {
    private final int ahD;
    private final int ahE;
    private final boolean ahF;
    private final Context mContext;

    public a(Context context, int i, int i2, boolean z) {
        this.mContext = context;
        this.ahD = i;
        this.ahE = i2;
        this.ahF = z;
    }

    public a(Context context, int i, int i2) {
        this(context, i, i2, false);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int wX() {
        return this.ahD;
    }

    public int wY() {
        return this.ahE;
    }

    public boolean wZ() {
        return this.ahF;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.ahD > 0 && this.ahE > 0;
    }
}
