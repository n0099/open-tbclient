package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d bF(Context context);

    public d bE(Context context) {
        d bF = bF(context);
        a(bF);
        b(bF);
        return bF;
    }
}
