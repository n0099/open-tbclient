package com.baidu.tbplugin;

import android.content.Context;
/* loaded from: classes.dex */
public final class o {
    private Class<?> a;
    private Context b;
    private p c = null;

    public o(Class<?> cls, Context context, p pVar) {
        this.a = cls;
        this.b = context;
    }

    public final synchronized void a() {
        new q(this, (byte) 0).executeOnExecutor(j.a().h(), new Void[0]);
    }
}
