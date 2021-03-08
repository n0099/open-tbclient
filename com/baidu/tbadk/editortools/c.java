package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(e eVar);

    protected abstract void b(e eVar);

    protected abstract e fg(Context context);

    public e ff(Context context) {
        e fg = fg(context);
        a(fg);
        b(fg);
        return fg;
    }
}
