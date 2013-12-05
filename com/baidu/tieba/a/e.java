package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.util.am;
/* loaded from: classes.dex */
public class e {
    private static final String c = com.baidu.tieba.data.h.f1248a + "c/s/clearmsg";

    /* renamed from: a  reason: collision with root package name */
    private am f1022a = null;
    private NewErrorData b = null;

    public void a(String str, String str2) {
        this.f1022a = new am(c);
        this.f1022a.a(PushConstants.EXTRA_USER_ID, str);
        this.f1022a.a("com_id", str2);
        String l = this.f1022a.l();
        this.b = new NewErrorData();
        this.b.parserJson(l);
    }

    public void a() {
        if (this.f1022a != null) {
            this.f1022a.j();
        }
    }

    public boolean b() {
        if (this.f1022a != null) {
            return this.f1022a.c();
        }
        return false;
    }

    public String c() {
        if (this.f1022a != null) {
            return this.f1022a.i();
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
