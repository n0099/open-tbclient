package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(e eVar);

    protected abstract void b(e eVar);

    protected abstract e ej(Context context);

    public e ei(Context context) {
        e ej = ej(context);
        a(ej);
        b(ej);
        return ej;
    }
}
