package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ag;
import com.baidu.tieba.util.r;
/* loaded from: classes.dex */
public class c {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.a) + "c/s/clearmsg";
    private r a = null;
    private ag b = null;

    public void a(String str, String str2) {
        this.a = new r(c);
        this.a.a(PushConstants.EXTRA_USER_ID, str);
        this.a.a("com_id", str2);
        String j = this.a.j();
        this.b = new ag();
        this.b.a(j);
    }

    public void a() {
        if (this.a != null) {
            this.a.h();
        }
    }

    public boolean b() {
        if (this.a != null) {
            return this.a.c();
        }
        return false;
    }

    public String c() {
        if (this.a != null) {
            return this.a.g();
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
