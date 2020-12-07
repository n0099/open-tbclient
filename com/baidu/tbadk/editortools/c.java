package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class c {
    protected abstract void a(e eVar);

    protected abstract void b(e eVar);

    protected abstract e eO(Context context);

    public e eN(Context context) {
        e eO = eO(context);
        a(eO);
        b(eO);
        return eO;
    }
}
