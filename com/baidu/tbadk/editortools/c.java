package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d dV(Context context);

    public d dU(Context context) {
        d dV = dV(context);
        a(dV);
        b(dV);
        return dV;
    }
}
