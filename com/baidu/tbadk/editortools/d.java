package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f aX(Context context);

    protected abstract void b(f fVar);

    public f aW(Context context) {
        f aX = aX(context);
        a(aX);
        b(aX);
        return aX;
    }
}
