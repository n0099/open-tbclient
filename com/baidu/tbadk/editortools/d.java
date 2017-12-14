package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f aW(Context context);

    protected abstract void b(f fVar);

    public f aV(Context context) {
        f aW = aW(context);
        a(aW);
        b(aW);
        return aW;
    }
}
