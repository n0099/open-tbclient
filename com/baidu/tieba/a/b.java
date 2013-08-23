package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.util.aq;
import com.baidu.tieba.util.v;
/* loaded from: classes.dex */
public class b {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/recentmsg";
    private static final String d = String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/historymsg";

    /* renamed from: a  reason: collision with root package name */
    private v f851a = null;
    private ak b = null;

    public String a(int i, String str, String str2, long j) {
        this.f851a = new v();
        this.f851a.a(PushConstants.EXTRA_USER_ID, str);
        this.f851a.a("com_id", str2);
        switch (i) {
            case 0:
                this.f851a.a(c);
                this.f851a.a("msg_id", String.valueOf(j));
                break;
            case 1:
                this.f851a.a(d);
                this.f851a.a("msg_id", String.valueOf(j));
                break;
        }
        String j2 = this.f851a.j();
        aq.a(getClass().getName(), "msg=" + j, j2);
        this.b = new ak();
        this.b.a(j2);
        return j2;
    }

    public void a() {
        if (this.f851a != null) {
            this.f851a.h();
        }
    }

    public boolean b() {
        if (this.f851a != null) {
            return this.f851a.c();
        }
        return false;
    }

    public String c() {
        if (this.f851a != null) {
            return this.f851a.g();
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
