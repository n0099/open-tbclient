package com.baidu.tieba.a.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aMy;
    private float aMz;

    public b(Context context) {
        super(context);
        this.aMy = false;
        this.aMz = -8.0f;
        u(this.aMz);
    }

    public void Jd() {
        uF();
        a(new c(this));
    }

    public void Je() {
        uF();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void Jf() {
        this.aMy = true;
    }

    @Override // com.baidu.tieba.a.b.a
    public void uF() {
        super.uF();
        this.aMy = false;
    }
}
