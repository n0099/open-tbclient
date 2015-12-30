package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f al(Context context);

    protected abstract void b(f fVar);

    public f ak(Context context) {
        f al = al(context);
        a(al);
        b(al);
        return al;
    }
}
