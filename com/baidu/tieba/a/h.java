package com.baidu.tieba.a;

import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.ag;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f997a = com.baidu.tieba.data.h.f1165a + "/c/s/uo/rand_share_template";
    private ag b;
    private ak c;

    public String a(String str) {
        this.b = new ag();
        this.b.a("share_type", str);
        this.b.a(f997a);
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
