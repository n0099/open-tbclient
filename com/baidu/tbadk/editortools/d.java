package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract void b(f fVar);

    protected abstract f bf(Context context);

    public f be(Context context) {
        f bf = bf(context);
        a(bf);
        b(bf);
        return bf;
    }
}
