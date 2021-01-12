package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(e eVar);

    protected abstract void b(e eVar);

    protected abstract e fi(Context context);

    public e fh(Context context) {
        e fi = fi(context);
        a(fi);
        b(fi);
        return fi;
    }
}
