package com.baidu.tieba.b;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.a.aj;
import com.baidu.tieba.a.i;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.t;
/* loaded from: classes.dex */
public class b {
    private static final String c = String.valueOf(i.e) + "c/s/recentmsg";
    private static final String d = String.valueOf(i.e) + "c/s/historymsg";
    private t a = null;
    private aj b = null;

    public String a(int i, String str, String str2, long j) {
        this.a = new t();
        this.a.a(PushConstants.EXTRA_USER_ID, str);
        this.a.a("com_id", str2);
        switch (i) {
            case 0:
                this.a.a(c);
                this.a.a("msg_id", String.valueOf(j));
                break;
            case 1:
                this.a.a(d);
                this.a.a("msg_id", String.valueOf(j));
                break;
        }
        String i2 = this.a.i();
        ae.a(getClass().getName(), "msg=" + j, i2);
        this.b = new aj();
        this.b.a(i2);
        return i2;
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
