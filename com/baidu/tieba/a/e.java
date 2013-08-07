package com.baidu.tieba.a;

import com.baidu.tieba.data.ao;
import com.baidu.tieba.util.u;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f831a = String.valueOf(com.baidu.tieba.data.g.f1011a) + "/c/s/uo/rand_share_template";
    private u b;
    private ao c;

    public String a(String str) {
        this.b = new u();
        this.b.a("share_type", str);
        this.b.a(f831a);
        String k = this.b.k();
        this.c = new ao();
        this.c.a(k);
        return k;
    }

    public void a() {
        if (this.b != null) {
            this.b.i();
        }
    }
}
