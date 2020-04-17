package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d dJ(Context context);

    public d dI(Context context) {
        d dJ = dJ(context);
        a(dJ);
        b(dJ);
        return dJ;
    }
}
