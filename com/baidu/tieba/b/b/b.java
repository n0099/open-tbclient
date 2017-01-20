package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    public int ahp;
    private boolean bii;
    private float bij;

    public b(Context context) {
        super(context);
        this.ahp = 3;
        this.bii = false;
        this.bij = -8.0f;
        S(this.bij);
    }

    public void Qi() {
        vF();
        a(new c(this));
    }

    public void Qj() {
        vF();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void Qk() {
        this.bii = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vF() {
        super.vF();
        this.bii = false;
    }
}
