package com.baidu.tbplugin;

import android.content.Context;
/* loaded from: classes.dex */
public final class m {
    private Class<?> a;
    private Context b;
    private n c = null;

    public m(Class<?> cls, Context context, n nVar) {
        this.a = cls;
        this.b = context;
    }

    public final synchronized void a() {
        new o(this, (byte) 0).executeOnExecutor(k.a().g(), new Void[0]);
    }
}
