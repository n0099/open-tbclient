package com.baidu.tieba.b;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.a.aj;
import com.baidu.tieba.a.i;
import com.baidu.tieba.d.t;
/* loaded from: classes.dex */
public class a {
    private static final String a = String.valueOf(i.e) + "c/s/addmsg";
    private t b = null;
    private aj c = null;

    public String a(com.baidu.tieba.a.a.e eVar) {
        this.b = new t(a);
        this.b.a(PushConstants.EXTRA_USER_ID, eVar.c());
        this.b.a("com_id", eVar.b());
        this.b.a(PushConstants.EXTRA_CONTENT, eVar.a());
        this.b.a("last_msg_id", String.valueOf(eVar.d()));
        String i = this.b.i();
        this.c = new aj();
        this.c.a(i);
        return i;
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
    }

    public boolean b() {
        if (this.b != null) {
            return this.b.b();
        }
        return false;
    }

    public String c() {
        if (this.b != null) {
            return this.b.f();
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
