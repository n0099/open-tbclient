package com.baidu.tbadk.d;

import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public final class b extends Thread {
    private int a;
    private int b;
    private String c = null;

    public b(int i, int i2) {
        this.a = 0;
        this.b = 0;
        this.a = i;
        this.b = i2;
    }

    public final void a(String str) {
        this.c = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        ak akVar = new ak(String.valueOf(n.a) + "c/s/pv");
        akVar.a("img_num", String.valueOf(this.a));
        akVar.a("img_total", String.valueOf(this.b));
        if (this.c != null) {
            akVar.a("img_type", this.c);
        }
        akVar.i();
    }
}
