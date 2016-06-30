package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f ag(Context context);

    protected abstract void b(f fVar);

    public f af(Context context) {
        f ag = ag(context);
        a(ag);
        b(ag);
        return ag;
    }
}
