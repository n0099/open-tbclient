package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    public int ana;
    private boolean bsF;
    private float bsG;

    public b(Context context) {
        super(context);
        this.ana = 3;
        this.bsF = false;
        this.bsG = -8.0f;
        R(this.bsG);
    }

    public void Si() {
        vK();
        a(new c(this));
    }

    public void Sj() {
        vK();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void Sk() {
        this.bsF = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vK() {
        super.vK();
        this.bsF = false;
    }
}
