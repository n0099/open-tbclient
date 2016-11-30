package com.baidu.tieba.b.b;

import android.content.Context;
/* loaded from: classes.dex */
public class b extends a {
    private boolean aZV;
    private float aZW;
    public int aiA;

    public b(Context context) {
        super(context);
        this.aiA = 3;
        this.aZV = false;
        this.aZW = -8.0f;
        Q(this.aZW);
    }

    public void Og() {
        wb();
        a(new c(this));
    }

    public void Oh() {
        wb();
        a(new d(this));
        a(new e(this));
        a(new f(this));
    }

    public void Oi() {
        this.aZV = true;
    }

    @Override // com.baidu.tieba.b.b.a
    public void wb() {
        super.wb();
        this.aZV = false;
    }
}
