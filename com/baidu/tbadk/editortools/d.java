package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f aZ(Context context);

    protected abstract void b(f fVar);

    public f aY(Context context) {
        f aZ = aZ(context);
        a(aZ);
        b(aZ);
        return aZ;
    }
}
