package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract d aZ(Context context);

    protected abstract void b(d dVar);

    public d aY(Context context) {
        d aZ = aZ(context);
        a(aZ);
        b(aZ);
        return aZ;
    }
}
