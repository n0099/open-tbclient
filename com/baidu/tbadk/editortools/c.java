package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(e eVar);

    protected abstract void b(e eVar);

    protected abstract e ec(Context context);

    public e eb(Context context) {
        e ec = ec(context);
        a(ec);
        b(ec);
        return ec;
    }
}
