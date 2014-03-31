package com.baidu.tbplugin;

import android.content.Context;
/* loaded from: classes.dex */
public final class a implements h {
    private Class<?> a;
    private i b;
    private Context c;
    private boolean d;

    private a(Context context, Class<?> cls) {
        this.a = cls;
        this.c = context;
    }

    public a(Context context, Class<?> cls, boolean z) {
        this(context, cls);
        this.d = z;
    }

    public a(Context context, Class<?> cls, boolean z, i iVar) {
        this(context, cls, z);
        this.b = iVar;
    }

    public final synchronized void a() {
        if (this.b == null) {
            new b(this, (byte) 0).a();
        } else {
            new b(this, (byte) 0).executeOnExecutor(k.a().g(), new Void[0]);
        }
    }
}
