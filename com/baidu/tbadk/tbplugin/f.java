package com.baidu.tbadk.tbplugin;

import android.content.Context;
import java.io.File;
/* loaded from: classes.dex */
public class f implements j {
    private Context a;
    private File b;
    private k c;
    private Class<?> d;

    public f(Context context, Class<?> cls, File file) {
        this.a = context;
        this.b = file;
        this.d = cls;
    }

    public f(Context context, Class<?> cls, String str, k kVar) {
        this(context, cls, new File(str));
        this.c = kVar;
    }

    public synchronized void a() {
        if (this.c == null) {
            new g(this, null).doInBackground(new Void[0]);
        } else {
            new g(this, null).executeOnExecutor(m.a().h(), new Void[0]);
        }
    }
}
