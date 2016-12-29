package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aYJ;
    private float aYK;
    public int aib;

    public b(Context context) {
        super(context);
        this.aib = 3;
        this.aYJ = false;
        this.aYK = -8.0f;
        R(this.aYK);
    }

    public void Ns() {
        vL();
        a(new c(this));
    }

    public void Nt() {
        vL();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void Nu() {
        this.aYJ = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vL() {
        super.vL();
        this.aYJ = false;
    }
}
