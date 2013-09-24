package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.z;
/* loaded from: classes.dex */
public class e {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/clearmsg";

    /* renamed from: a  reason: collision with root package name */
    private z f867a = null;
    private ak b = null;

    public void a(String str, String str2) {
        this.f867a = new z(c);
        this.f867a.a(PushConstants.EXTRA_USER_ID, str);
        this.f867a.a("com_id", str2);
        String j = this.f867a.j();
        this.b = new ak();
        this.b.a(j);
    }

    public void a() {
        if (this.f867a != null) {
            this.f867a.h();
        }
    }

    public boolean b() {
        if (this.f867a != null) {
            return this.f867a.c();
        }
        return false;
    }

    public String c() {
        if (this.f867a != null) {
            return this.f867a.g();
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
