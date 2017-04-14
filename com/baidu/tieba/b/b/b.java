package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    public int amZ;
    private boolean boK;
    private float boL;

    public b(Context context) {
        super(context);
        this.amZ = 3;
        this.boK = false;
        this.boL = -8.0f;
        S(this.boL);
    }

    public void Rz() {
        wz();
        a(new c(this));
    }

    public void RA() {
        wz();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void RB() {
        this.boK = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wz() {
        super.wz();
        this.boK = false;
    }
}
