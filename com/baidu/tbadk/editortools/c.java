package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d dO(Context context);

    public d dN(Context context) {
        d dO = dO(context);
        a(dO);
        b(dO);
        return dO;
    }
}
