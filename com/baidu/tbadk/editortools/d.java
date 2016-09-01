package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f aq(Context context);

    protected abstract void b(f fVar);

    public f ap(Context context) {
        f aq = aq(context);
        a(aq);
        b(aq);
        return aq;
    }
}
