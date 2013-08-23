package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.v;
/* loaded from: classes.dex */
public class c {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/clearmsg";

    /* renamed from: a  reason: collision with root package name */
    private v f852a = null;
    private ak b = null;

    public void a(String str, String str2) {
        this.f852a = new v(c);
        this.f852a.a(PushConstants.EXTRA_USER_ID, str);
        this.f852a.a("com_id", str2);
        String j = this.f852a.j();
        this.b = new ak();
        this.b.a(j);
    }

    public void a() {
        if (this.f852a != null) {
            this.f852a.h();
        }
    }

    public boolean b() {
        if (this.f852a != null) {
            return this.f852a.c();
        }
        return false;
    }

    public String c() {
        if (this.f852a != null) {
            return this.f852a.g();
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
