package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(e eVar);

    protected abstract void b(e eVar);

    protected abstract e fh(Context context);

    public e fg(Context context) {
        e fh = fh(context);
        a(fh);
        b(fh);
        return fh;
    }
}
