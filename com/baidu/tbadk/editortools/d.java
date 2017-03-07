package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f aM(Context context);

    protected abstract void b(f fVar);

    public f aL(Context context) {
        f aM = aM(context);
        a(aM);
        b(aM);
        return aM;
    }
}
