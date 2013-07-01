package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ag;
import com.baidu.tieba.util.r;
/* loaded from: classes.dex */
public class c {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/clearmsg";

    /* renamed from: a  reason: collision with root package name */
    private r f623a = null;
    private ag b = null;

    public void a(String str, String str2) {
        this.f623a = new r(c);
        this.f623a.a(PushConstants.EXTRA_USER_ID, str);
        this.f623a.a("com_id", str2);
        String j = this.f623a.j();
        this.b = new ag();
        this.b.a(j);
    }

    public void a() {
        if (this.f623a != null) {
            this.f623a.h();
        }
    }

    public boolean b() {
        if (this.f623a != null) {
            return this.f623a.c();
        }
        return false;
    }

    public String c() {
        if (this.f623a != null) {
            return this.f623a.g();
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
