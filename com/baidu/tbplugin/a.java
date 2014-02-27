package com.baidu.tbplugin;

import android.content.Context;
/* loaded from: classes.dex */
public final class a implements g {
    private Class<?> a;
    private h b;
    private Context c;

    public a(Context context, Class<?> cls, h hVar) {
        this.b = hVar;
        this.a = cls;
        this.c = context;
    }

    public final synchronized void a() {
        new b(this, (byte) 0).executeOnExecutor(j.a().h(), new Void[0]);
    }
}
