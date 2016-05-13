package com.baidu.tbadk.coreExtra.data;

import android.content.Context;
/* loaded from: classes.dex */
public class a {
    private final int afv;
    private final int afw;
    private final boolean afx;
    private final Context mContext;

    public a(Context context, int i, int i2, boolean z) {
        this.mContext = context;
        this.afv = i;
        this.afw = i2;
        this.afx = z;
    }

    public a(Context context, int i, int i2) {
        this(context, i, i2, false);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int wp() {
        return this.afv;
    }

    public int wq() {
        return this.afw;
    }

    public boolean wr() {
        return this.afx;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.afv > 0 && this.afw > 0;
    }
}
