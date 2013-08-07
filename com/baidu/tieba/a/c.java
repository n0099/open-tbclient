package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.util.u;
/* loaded from: classes.dex */
public class c {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/clearmsg";

    /* renamed from: a  reason: collision with root package name */
    private u f830a = null;
    private ao b = null;

    public void a(String str, String str2) {
        this.f830a = new u(c);
        this.f830a.a(PushConstants.EXTRA_USER_ID, str);
        this.f830a.a("com_id", str2);
        String k = this.f830a.k();
        this.b = new ao();
        this.b.a(k);
    }

    public void a() {
        if (this.f830a != null) {
            this.f830a.i();
        }
    }

    public boolean b() {
        if (this.f830a != null) {
            return this.f830a.d();
        }
        return false;
    }

    public String c() {
        if (this.f830a != null) {
            return this.f830a.h();
        }
        return null;
    }

    public int d() {
        if (this.b != null) {
            return this.b.a();
        }
        return -1;
    }

    public String e() {
        if (this.b != null) {
            return this.b.b();
        }
        return null;
    }
}
