package com.baidu.tbadk.coreExtra.data;

import android.content.Context;
/* loaded from: classes.dex */
public class a {
    private final int ajJ;
    private final int ajK;
    private final boolean ajL;
    private final Context mContext;

    public a(Context context, int i, int i2, boolean z) {
        this.mContext = context;
        this.ajJ = i;
        this.ajK = i2;
        this.ajL = z;
    }

    public a(Context context, int i, int i2) {
        this(context, i, i2, false);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int yv() {
        return this.ajJ;
    }

    public int yw() {
        return this.ajK;
    }

    public boolean yx() {
        return this.ajL;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.ajJ > 0 && this.ajK > 0;
    }
}
