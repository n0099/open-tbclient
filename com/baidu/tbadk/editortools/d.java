package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class d {
    protected abstract void a(f fVar);

    protected abstract f aR(Context context);

    protected abstract void b(f fVar);

    public f aQ(Context context) {
        f aR = aR(context);
        a(aR);
        b(aR);
        return aR;
    }
}
