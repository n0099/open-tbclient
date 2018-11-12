package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d bK(Context context);

    public d bJ(Context context) {
        d bK = bK(context);
        a(bK);
        b(bK);
        return bK;
    }
}
