package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.ag;
/* loaded from: classes.dex */
public class e {
    private static final String c = com.baidu.tieba.data.h.f1165a + "c/s/clearmsg";

    /* renamed from: a  reason: collision with root package name */
    private ag f996a = null;
    private ak b = null;

    public void a(String str, String str2) {
        this.f996a = new ag(c);
        this.f996a.a(PushConstants.EXTRA_USER_ID, str);
        this.f996a.a("com_id", str2);
        String j = this.f996a.j();
        this.b = new ak();
        this.b.a(j);
    }

    public void a() {
        if (this.f996a != null) {
            this.f996a.h();
        }
    }

    public boolean b() {
        if (this.f996a != null) {
            return this.f996a.c();
        }
        return false;
    }

    public String c() {
        if (this.f996a != null) {
            return this.f996a.g();
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
