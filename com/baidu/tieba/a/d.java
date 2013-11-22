package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bg;
/* loaded from: classes.dex */
public class d {
    private static final String c = com.baidu.tieba.data.h.f1201a + "c/s/recentmsg";
    private static final String d = com.baidu.tieba.data.h.f1201a + "c/s/historymsg";

    /* renamed from: a  reason: collision with root package name */
    private ap f1011a = null;
    private NewErrorData b = null;

    public String a(int i, String str, String str2, long j) {
        this.f1011a = new ap();
        this.f1011a.a(PushConstants.EXTRA_USER_ID, str);
        this.f1011a.a("com_id", str2);
        switch (i) {
            case 0:
                this.f1011a.a(c);
                this.f1011a.a("msg_id", String.valueOf(j));
                break;
            case 1:
                this.f1011a.a(d);
                this.f1011a.a("msg_id", String.valueOf(j));
                break;
        }
        String l = this.f1011a.l();
        bg.a(getClass().getName(), "msg=" + j, l);
        this.b = new NewErrorData();
        this.b.parserJson(l);
        return l;
    }

    public void a() {
        if (this.f1011a != null) {
            this.f1011a.j();
        }
    }

    public boolean b() {
        if (this.f1011a != null) {
            return this.f1011a.c();
        }
        return false;
    }

    public String c() {
        if (this.f1011a != null) {
            return this.f1011a.i();
        }
        return null;
    }

    public int d() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        return -1;
    }

    public String e() {
        if (this.b != null) {
            return this.b.getErrorMsg();
        }
        return null;
    }
}
