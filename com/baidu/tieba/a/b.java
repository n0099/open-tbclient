package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.util.u;
/* loaded from: classes.dex */
public class b {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/recentmsg";
    private static final String d = String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/historymsg";

    /* renamed from: a  reason: collision with root package name */
    private u f831a = null;
    private ao b = null;

    public String a(int i, String str, String str2, long j) {
        this.f831a = new u();
        this.f831a.a(PushConstants.EXTRA_USER_ID, str);
        this.f831a.a("com_id", str2);
        switch (i) {
            case 0:
                this.f831a.a(c);
                this.f831a.a("msg_id", String.valueOf(j));
                break;
            case 1:
                this.f831a.a(d);
                this.f831a.a("msg_id", String.valueOf(j));
                break;
        }
        String k = this.f831a.k();
        aj.a(getClass().getName(), "msg=" + j, k);
        this.b = new ao();
        this.b.a(k);
        return k;
    }

    public void a() {
        if (this.f831a != null) {
            this.f831a.i();
        }
    }

    public boolean b() {
        if (this.f831a != null) {
            return this.f831a.d();
        }
        return false;
    }

    public String c() {
        if (this.f831a != null) {
            return this.f831a.h();
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
