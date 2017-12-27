package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract void b(f fVar);

    protected abstract f bi(Context context);

    public f bh(Context context) {
        f bi = bi(context);
        a(bi);
        b(bi);
        return bi;
    }
}
