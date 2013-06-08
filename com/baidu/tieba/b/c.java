package com.baidu.tieba.b;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.a.aj;
import com.baidu.tieba.a.i;
import com.baidu.tieba.d.t;
/* loaded from: classes.dex */
public class c {
    private static final String c = String.valueOf(i.e) + "c/s/clearmsg";
    private t a = null;
    private aj b = null;

    public void a(String str, String str2) {
        this.a = new t(c);
        this.a.a(PushConstants.EXTRA_USER_ID, str);
        this.a.a("com_id", str2);
        String i = this.a.i();
        this.b = new aj();
        this.b.a(i);
    }

    public void a() {
        if (this.a != null) {
            this.a.g();
        }
    }

    public boolean b() {
        if (this.a != null) {
            return this.a.b();
        }
        return false;
    }

    public String c() {
        if (this.a != null) {
            return this.a.f();
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
