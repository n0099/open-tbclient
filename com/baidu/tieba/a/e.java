package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.util.ap;
/* loaded from: classes.dex */
public class e {
    private static final String c = com.baidu.tieba.data.h.f1201a + "c/s/clearmsg";

    /* renamed from: a  reason: collision with root package name */
    private ap f1012a = null;
    private NewErrorData b = null;

    public void a(String str, String str2) {
        this.f1012a = new ap(c);
        this.f1012a.a(PushConstants.EXTRA_USER_ID, str);
        this.f1012a.a("com_id", str2);
        String l = this.f1012a.l();
        this.b = new NewErrorData();
        this.b.parserJson(l);
    }

    public void a() {
        if (this.f1012a != null) {
            this.f1012a.j();
        }
    }

    public boolean b() {
        if (this.f1012a != null) {
            return this.f1012a.c();
        }
        return false;
    }

    public String c() {
        if (this.f1012a != null) {
            return this.f1012a.i();
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
