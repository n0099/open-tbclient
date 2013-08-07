package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.util.u;
/* loaded from: classes.dex */
public class b {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/recentmsg";
    private static final String d = String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/historymsg";

    /* renamed from: a  reason: collision with root package name */
    private u f829a = null;
    private ao b = null;

    public String a(int i, String str, String str2, long j) {
        this.f829a = new u();
        this.f829a.a(PushConstants.EXTRA_USER_ID, str);
        this.f829a.a("com_id", str2);
        switch (i) {
            case 0:
                this.f829a.a(c);
                this.f829a.a("msg_id", String.valueOf(j));
                break;
            case 1:
                this.f829a.a(d);
                this.f829a.a("msg_id", String.valueOf(j));
                break;
        }
        String k = this.f829a.k();
        aj.a(getClass().getName(), "msg=" + j, k);
        this.b = new ao();
        this.b.a(k);
        return k;
    }

    public void a() {
        if (this.f829a != null) {
            this.f829a.i();
        }
    }

    public boolean b() {
        if (this.f829a != null) {
            return this.f829a.d();
        }
        return false;
    }

    public String c() {
        if (this.f829a != null) {
            return this.f829a.h();
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
