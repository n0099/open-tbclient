package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d ba(Context context);

    public d aZ(Context context) {
        d ba = ba(context);
        a(ba);
        b(ba);
        return ba;
    }
}
