package com.baidu.tbplugin;

import android.content.Context;
/* loaded from: classes.dex */
public class a implements g {
    private Class<?> a;
    private h b;
    private Context c;

    public a(Context context, Class<?> cls, h hVar) {
        this.b = hVar;
        this.a = cls;
        this.c = context;
    }

    public synchronized void a() {
        new b(this, null).execute(new Void[0]);
    }
}
