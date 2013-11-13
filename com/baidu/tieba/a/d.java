package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bg;
/* loaded from: classes.dex */
public class d {
    private static final String c = com.baidu.tieba.data.h.f1196a + "c/s/recentmsg";
    private static final String d = com.baidu.tieba.data.h.f1196a + "c/s/historymsg";

    /* renamed from: a  reason: collision with root package name */
    private ap f1009a = null;
    private NewErrorData b = null;

    public String a(int i, String str, String str2, long j) {
        this.f1009a = new ap();
        this.f1009a.a(PushConstants.EXTRA_USER_ID, str);
        this.f1009a.a("com_id", str2);
        switch (i) {
            case 0:
                this.f1009a.a(c);
                this.f1009a.a("msg_id", String.valueOf(j));
                break;
            case 1:
                this.f1009a.a(d);
                this.f1009a.a("msg_id", String.valueOf(j));
                break;
        }
        String j2 = this.f1009a.j();
        bg.a(getClass().getName(), "msg=" + j, j2);
        this.b = new NewErrorData();
        this.b.parserJson(j2);
        return j2;
    }

    public void a() {
        if (this.f1009a != null) {
            this.f1009a.h();
        }
    }

    public boolean b() {
        if (this.f1009a != null) {
            return this.f1009a.c();
        }
        return false;
    }

    public String c() {
        if (this.f1009a != null) {
            return this.f1009a.g();
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
