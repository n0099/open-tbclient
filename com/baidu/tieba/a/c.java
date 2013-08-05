package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.util.u;
/* loaded from: classes.dex */
public class c {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/clearmsg";

    /* renamed from: a  reason: collision with root package name */
    private u f832a = null;
    private ao b = null;

    public void a(String str, String str2) {
        this.f832a = new u(c);
        this.f832a.a(PushConstants.EXTRA_USER_ID, str);
        this.f832a.a("com_id", str2);
        String k = this.f832a.k();
        this.b = new ao();
        this.b.a(k);
    }

    public void a() {
        if (this.f832a != null) {
            this.f832a.i();
        }
    }

    public boolean b() {
        if (this.f832a != null) {
            return this.f832a.d();
        }
        return false;
    }

    public String c() {
        if (this.f832a != null) {
            return this.f832a.h();
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
