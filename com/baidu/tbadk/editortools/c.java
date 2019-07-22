package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d cL(Context context);

    public d cK(Context context) {
        d cL = cL(context);
        a(cL);
        b(cL);
        return cL;
    }
}
