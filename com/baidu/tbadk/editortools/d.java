package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract void b(f fVar);

    protected abstract f be(Context context);

    public f bd(Context context) {
        f be = be(context);
        a(be);
        b(be);
        return be;
    }
}
