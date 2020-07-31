package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d dU(Context context);

    public d dT(Context context) {
        d dU = dU(context);
        a(dU);
        b(dU);
        return dU;
    }
}
