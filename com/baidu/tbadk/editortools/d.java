package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f ao(Context context);

    protected abstract void b(f fVar);

    public f an(Context context) {
        f ao = ao(context);
        a(ao);
        b(ao);
        return ao;
    }
}
