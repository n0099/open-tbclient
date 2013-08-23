package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.v;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f850a = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/addmsg";
    private v b = null;
    private ak c = null;

    public String a(com.baidu.tieba.data.a.e eVar) {
        this.b = new v(f850a);
        this.b.a(PushConstants.EXTRA_USER_ID, eVar.c());
        this.b.a("com_id", eVar.b());
        this.b.a("content", eVar.a());
        this.b.a("last_msg_id", String.valueOf(eVar.d()));
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

    public boolean b() {
        if (this.b != null) {
            return this.b.c();
        }
        return false;
    }

    public String c() {
        if (this.b != null) {
            return this.b.g();
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
