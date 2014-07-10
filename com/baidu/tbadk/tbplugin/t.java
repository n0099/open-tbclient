package com.baidu.tbadk.tbplugin;

import android.content.Context;
/* loaded from: classes.dex */
public class t {
    private Class<?> a;
    private Context b;
    private u c;

    public t(Class<?> cls, Context context, u uVar) {
        this.a = cls;
        this.b = context;
        this.c = uVar;
    }

    public synchronized void a() {
        new v(this, null).executeOnExecutor(m.a().h(), new Void[0]);
    }
}
