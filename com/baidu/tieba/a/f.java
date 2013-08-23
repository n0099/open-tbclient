package com.baidu.tieba.a;

import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.v;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f853a = String.valueOf(com.baidu.tieba.data.g.f1014a) + "/c/s/uo/rand_share_template";
    private v b;
    private ak c;

    public String a(String str) {
        this.b = new v();
        this.b.a("share_type", str);
        this.b.a(f853a);
        String j = this.b.j();
        this.c = new ak();
        this.c.a(j);
        return j;
    }

    public void a() {
        if (this.b != null) {
            this.b.h();
        }
    }
}
