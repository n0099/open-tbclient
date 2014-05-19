package com.baidu.tbadk.tbplugin;

import android.content.Context;
/* loaded from: classes.dex */
public class a implements j {
    private Class<?> a;
    private k b;
    private Context c;
    private boolean d;

    public a(Context context, Class<?> cls) {
        this.a = cls;
        this.c = context;
    }

    public a(Context context, Class<?> cls, boolean z) {
        this(context, cls);
        this.d = z;
    }

    public a(Context context, Class<?> cls, boolean z, k kVar) {
        this(context, cls, z);
        this.b = kVar;
    }

    public synchronized void a() {
        if (this.b == null) {
            new b(this, null).doInBackground(new Void[0]);
        } else {
            new b(this, null).executeOnExecutor(m.a().h(), new Void[0]);
        }
    }
}
