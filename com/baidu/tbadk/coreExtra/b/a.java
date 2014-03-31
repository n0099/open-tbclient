package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.a.h;
/* loaded from: classes.dex */
public final class a {
    private b a;
    private h b;

    public a(h hVar) {
        this.b = hVar;
    }

    public final void a(boolean z, String str, String str2) {
        if (this.a == null) {
            this.a = new b(this, (byte) 0);
            this.a.setPriority(2);
            this.a.a(z);
            this.a.a2(str);
            this.a.b(str2);
            this.a.execute(new Integer[0]);
        }
    }

    public final void a() {
        if (this.a != null) {
            this.a.cancel();
        }
    }
}
