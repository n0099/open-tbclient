package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.base.g;
/* loaded from: classes.dex */
public class a {
    private b a;
    private g b;

    public a(g gVar) {
        this.b = gVar;
    }

    public void a(boolean z, String str, String str2) {
        if (this.a == null) {
            this.a = new b(this, null);
            this.a.setPriority(2);
            this.a.a(z);
            this.a.a(str);
            this.a.b(str2);
            this.a.execute(new Integer[0]);
        }
    }

    public void a() {
        if (this.a != null) {
            this.a.cancel();
        }
    }
}
