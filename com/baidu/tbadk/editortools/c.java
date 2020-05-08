package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d dx(Context context);

    public d dw(Context context) {
        d dx = dx(context);
        a(dx);
        b(dx);
        return dx;
    }
}
