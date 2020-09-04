package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(e eVar);

    protected abstract void b(e eVar);

    protected abstract e ed(Context context);

    public e ec(Context context) {
        e ed = ed(context);
        a(ed);
        b(ed);
        return ed;
    }
}
