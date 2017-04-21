package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    public int amZ;
    private boolean brb;
    private float brc;

    public b(Context context) {
        super(context);
        this.amZ = 3;
        this.brb = false;
        this.brc = -8.0f;
        S(this.brc);
    }

    public void SB() {
        wz();
        a(new c(this));
    }

    public void SC() {
        wz();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void SD() {
        this.brb = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wz() {
        super.wz();
        this.brb = false;
    }
}
