package com.baidu.tbadk.d.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int aop;
    private int aoq;
    public int aor;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.aop = i;
        this.iconId = i2;
        this.aor = i3;
        this.aoq = i4;
    }

    public int AJ() {
        return this.iconId;
    }

    public int AK() {
        return this.aop;
    }
}
