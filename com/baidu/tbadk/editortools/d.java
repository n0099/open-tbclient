package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f ah(Context context);

    protected abstract void b(f fVar);

    public f ag(Context context) {
        f ah = ah(context);
        a(ah);
        b(ah);
        return ah;
    }
}
