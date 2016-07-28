package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aQL;
    private float aQM;
    public int afy;

    public b(Context context) {
        super(context);
        this.afy = 3;
        this.aQL = false;
        this.aQM = -8.0f;
        E(this.aQM);
    }

    public void Ka() {
        uE();
        a(new c(this));
    }

    public void Kb() {
        uE();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void Kc() {
        this.aQL = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void uE() {
        super.uE();
        this.aQL = false;
    }
}
