package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d dP(Context context);

    public d dO(Context context) {
        d dP = dP(context);
        a(dP);
        b(dP);
        return dP;
    }
}
