package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
public class d {
    private static final String c = com.baidu.tieba.data.h.f1165a + "c/s/recentmsg";
    private static final String d = com.baidu.tieba.data.h.f1165a + "c/s/historymsg";

    /* renamed from: a  reason: collision with root package name */
    private ag f995a = null;
    private ak b = null;

    public String a(int i, String str, String str2, long j) {
        this.f995a = new ag();
        this.f995a.a(PushConstants.EXTRA_USER_ID, str);
        this.f995a.a("com_id", str2);
        switch (i) {
            case 0:
                this.f995a.a(c);
                this.f995a.a("msg_id", String.valueOf(j));
                break;
            case 1:
                this.f995a.a(d);
                this.f995a.a("msg_id", String.valueOf(j));
                break;
        }
        String j2 = this.f995a.j();
        be.a(getClass().getName(), "msg=" + j, j2);
        this.b = new ak();
        this.b.a(j2);
        return j2;
    }

    public void a() {
        if (this.f995a != null) {
            this.f995a.h();
        }
    }

    public boolean b() {
        if (this.f995a != null) {
            return this.f995a.c();
        }
        return false;
    }

    public String c() {
        if (this.f995a != null) {
            return this.f995a.g();
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
