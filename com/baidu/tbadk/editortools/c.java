package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract d aP(Context context);

    protected abstract void b(d dVar);

    public d aO(Context context) {
        d aP = aP(context);
        a(aP);
        b(aP);
        return aP;
    }
}
