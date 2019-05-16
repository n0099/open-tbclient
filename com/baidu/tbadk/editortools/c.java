package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(d dVar);

    protected abstract void b(d dVar);

    protected abstract d cK(Context context);

    public d cJ(Context context) {
        d cK = cK(context);
        a(cK);
        b(cK);
        return cK;
    }
}
