package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aWj;
    private float aWk;
    public int ait;

    public b(Context context) {
        super(context);
        this.ait = 3;
        this.aWj = false;
        this.aWk = -8.0f;
        Q(this.aWk);
    }

    public void MC() {
        vJ();
        a(new c(this));
    }

    public void MD() {
        vJ();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void ME() {
        this.aWj = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vJ() {
        super.vJ();
        this.aWj = false;
    }
}
