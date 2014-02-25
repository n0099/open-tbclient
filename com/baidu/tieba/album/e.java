package com.baidu.tieba.album;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class e {
    private final String a = e.class.getName();
    private final String b = com.baidu.tieba.data.i.k();
    private f c;
    private g d;
    private Context e;

    public e(Context context) {
        this.e = context;
    }

    public boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        a();
        this.c = new f(this, oVar);
        this.c.setPriority(3);
        this.c.execute(new Object[0]);
        return true;
    }

    public boolean a(String str, ak akVar) {
        if (akVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        b();
        this.d = new g(this, str, akVar);
        this.d.setPriority(3);
        this.d.execute(new Object[0]);
        return true;
    }

    public void a() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    public void b() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }
}
