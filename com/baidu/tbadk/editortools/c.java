package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d dS(Context context);

    public d dR(Context context) {
        d dS = dS(context);
        a(dS);
        b(dS);
        return dS;
    }
}
