package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d de(Context context);

    public d dd(Context context) {
        d de = de(context);
        a(de);
        b(de);
        return de;
    }
}
