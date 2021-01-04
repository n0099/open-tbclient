package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(e eVar);

    protected abstract void b(e eVar);

    protected abstract e fk(Context context);

    public e fj(Context context) {
        e fk = fk(context);
        a(fk);
        b(fk);
        return fk;
    }
}
