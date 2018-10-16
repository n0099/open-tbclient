package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d bN(Context context);

    public d bM(Context context) {
        d bN = bN(context);
        a(bN);
        b(bN);
        return bN;
    }
}
