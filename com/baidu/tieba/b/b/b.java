package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    public int amL;
    private boolean boR;
    private float boS;

    public b(Context context) {
        super(context);
        this.amL = 3;
        this.boR = false;
        this.boS = -8.0f;
        S(this.boS);
    }

    public void Rb() {
        wc();
        a(new c(this));
    }

    public void Rc() {
        wc();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void Rd() {
        this.boR = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wc() {
        super.wc();
        this.boR = false;
    }
}
