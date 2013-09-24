package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.z;
/* loaded from: classes.dex */
public class d {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/recentmsg";
    private static final String d = String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/historymsg";

    /* renamed from: a  reason: collision with root package name */
    private z f866a = null;
    private ak b = null;

    public String a(int i, String str, String str2, long j) {
        this.f866a = new z();
        this.f866a.a(PushConstants.EXTRA_USER_ID, str);
        this.f866a.a("com_id", str2);
        switch (i) {
            case 0:
                this.f866a.a(c);
                this.f866a.a("msg_id", String.valueOf(j));
                break;
            case 1:
                this.f866a.a(d);
                this.f866a.a("msg_id", String.valueOf(j));
                break;
        }
        String j2 = this.f866a.j();
        av.a(getClass().getName(), "msg=" + j, j2);
        this.b = new ak();
        this.b.a(j2);
        return j2;
    }

    public void a() {
        if (this.f866a != null) {
            this.f866a.h();
        }
    }

    public boolean b() {
        if (this.f866a != null) {
            return this.f866a.c();
        }
        return false;
    }

    public String c() {
        if (this.f866a != null) {
            return this.f866a.g();
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
