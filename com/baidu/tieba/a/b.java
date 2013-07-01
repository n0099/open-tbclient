package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ag;
import com.baidu.tieba.util.r;
import com.baidu.tieba.util.z;
/* loaded from: classes.dex */
public class b {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/recentmsg";
    private static final String d = String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/historymsg";

    /* renamed from: a  reason: collision with root package name */
    private r f622a = null;
    private ag b = null;

    public String a(int i, String str, String str2, long j) {
        this.f622a = new r();
        this.f622a.a(PushConstants.EXTRA_USER_ID, str);
        this.f622a.a("com_id", str2);
        switch (i) {
            case 0:
                this.f622a.a(c);
                this.f622a.a("msg_id", String.valueOf(j));
                break;
            case 1:
                this.f622a.a(d);
                this.f622a.a("msg_id", String.valueOf(j));
                break;
        }
        String j2 = this.f622a.j();
        z.a(getClass().getName(), "msg=" + j, j2);
        this.b = new ag();
        this.b.a(j2);
        return j2;
    }

    public void a() {
        if (this.f622a != null) {
            this.f622a.h();
        }
    }

    public boolean b() {
        if (this.f622a != null) {
            return this.f622a.c();
        }
        return false;
    }

    public String c() {
        if (this.f622a != null) {
            return this.f622a.g();
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
