package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aPR;
    private float aPS;
    public int aeK;

    public b(Context context) {
        super(context);
        this.aeK = 3;
        this.aPR = false;
        this.aPS = -8.0f;
        u(this.aPS);
    }

    public void Kb() {
        uE();
        a(new c(this));
    }

    public void Kc() {
        uE();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void Kd() {
        this.aPR = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void uE() {
        super.uE();
        this.aPR = false;
    }
}
