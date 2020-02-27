package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d dW(Context context);

    public d dV(Context context) {
        d dW = dW(context);
        a(dW);
        b(dW);
        return dW;
    }
}
