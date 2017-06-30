package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    public int aoa;
    private boolean bws;
    private float bwt;

    public b(Context context) {
        super(context);
        this.aoa = 3;
        this.bws = false;
        this.bwt = -8.0f;
        R(this.bwt);
    }

    public void TX() {
        wb();
        a(new c(this));
    }

    public void TY() {
        wb();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void TZ() {
        this.bws = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wb() {
        super.wb();
        this.bws = false;
    }
}
