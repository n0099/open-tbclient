package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f aO(Context context);

    protected abstract void b(f fVar);

    public f aN(Context context) {
        f aO = aO(context);
        a(aO);
        b(aO);
        return aO;
    }
}
