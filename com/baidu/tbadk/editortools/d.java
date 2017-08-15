package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f aS(Context context);

    protected abstract void b(f fVar);

    public f aR(Context context) {
        f aS = aS(context);
        a(aS);
        b(aS);
        return aS;
    }
}
