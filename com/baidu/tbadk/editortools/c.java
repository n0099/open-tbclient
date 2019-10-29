package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d cx(Context context);

    public d cw(Context context) {
        d cx = cx(context);
        a(cx);
        b(cx);
        return cx;
    }
}
