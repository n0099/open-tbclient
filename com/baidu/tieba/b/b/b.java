package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    public int ane;
    private boolean bry;
    private float brz;

    public b(Context context) {
        super(context);
        this.ane = 3;
        this.bry = false;
        this.brz = -8.0f;
        S(this.brz);
    }

    public void RW() {
        vN();
        a(new c(this));
    }

    public void RX() {
        vN();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void RY() {
        this.bry = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void vN() {
        super.vN();
        this.bry = false;
    }
}
