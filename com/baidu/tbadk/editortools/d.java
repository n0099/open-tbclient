package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f aY(Context context);

    protected abstract void b(f fVar);

    public f aX(Context context) {
        f aY = aY(context);
        a(aY);
        b(aY);
        return aY;
    }
}
