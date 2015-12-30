package com.baidu.tbadk.d.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int arn;
    private int aro;
    public int arp;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.arn = i;
        this.iconId = i2;
        this.arp = i3;
        this.aro = i4;
    }

    public int AT() {
        return this.iconId;
    }

    public int AU() {
        return this.arn;
    }
}
