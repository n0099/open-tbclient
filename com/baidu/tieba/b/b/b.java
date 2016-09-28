package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aWN;
    private float aWO;
    public int ahV;

    public b(Context context) {
        super(context);
        this.ahV = 3;
        this.aWN = false;
        this.aWO = -8.0f;
        Q(this.aWO);
    }

    public void Nd() {
        vX();
        a(new c(this));
    }

    public void Ne() {
        vX();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void Nf() {
        this.aWN = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vX() {
        super.vX();
        this.aWN = false;
    }
}
