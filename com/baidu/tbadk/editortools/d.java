package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f ai(Context context);

    protected abstract void b(f fVar);

    public f ah(Context context) {
        f ai = ai(context);
        a(ai);
        b(ai);
        return ai;
    }
}
