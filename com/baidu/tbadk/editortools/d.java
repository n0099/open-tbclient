package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f am(Context context);

    protected abstract void b(f fVar);

    public f al(Context context) {
        f am = am(context);
        a(am);
        b(am);
        return am;
    }
}
