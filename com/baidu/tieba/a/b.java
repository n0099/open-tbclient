package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ag;
import com.baidu.tieba.util.r;
import com.baidu.tieba.util.z;
/* loaded from: classes.dex */
public class b {
    private static final String c = String.valueOf(com.baidu.tieba.data.g.a) + "c/s/recentmsg";
    private static final String d = String.valueOf(com.baidu.tieba.data.g.a) + "c/s/historymsg";
    private r a = null;
    private ag b = null;

    public String a(int i, String str, String str2, long j) {
        this.a = new r();
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
        String j2 = this.a.j();
        z.a(getClass().getName(), "msg=" + j, j2);
        this.b = new ag();
        this.b.a(j2);
        return j2;
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
