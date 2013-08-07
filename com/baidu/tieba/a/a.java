package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.util.u;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f828a = String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/addmsg";
    private u b = null;
    private ao c = null;

    public String a(com.baidu.tieba.data.a.e eVar) {
        this.b = new u(f828a);
        this.b.a(PushConstants.EXTRA_USER_ID, eVar.c());
        this.b.a("com_id", eVar.b());
        this.b.a("content", eVar.a());
        this.b.a("last_msg_id", String.valueOf(eVar.d()));
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

    public boolean b() {
        if (this.b != null) {
            return this.b.d();
        }
        return false;
    }

    public String c() {
        if (this.b != null) {
            return this.b.h();
        }
        return null;
    }

    public int d() {
        if (this.c != null) {
            return this.c.a();
        }
        return -1;
    }

    public String e() {
        if (this.c != null) {
            return this.c.b();
        }
        return null;
    }
}
