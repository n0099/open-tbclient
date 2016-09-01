package com.baidu.tbadk.coreExtra.data;

import android.content.Context;
/* loaded from: classes.dex */
public class e {
    private final int ajO;
    private final int ajP;
    private final boolean ajQ;
    private final Context mContext;

    public e(Context context, int i, int i2, boolean z) {
        this.mContext = context;
        this.ajO = i;
        this.ajP = i2;
        this.ajQ = z;
    }

    public e(Context context, int i, int i2) {
        this(context, i, i2, false);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int xC() {
        return this.ajO;
    }

    public int xD() {
        return this.ajP;
    }

    public boolean xE() {
        return this.ajQ;
    }

    public boolean isAvailable() {
        return this.mContext != null && this.ajO > 0 && this.ajP > 0;
    }
}
