package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.util.ap;
/* loaded from: classes.dex */
public class e {
    private static final String c = com.baidu.tieba.data.h.f1196a + "c/s/clearmsg";

    /* renamed from: a  reason: collision with root package name */
    private ap f1010a = null;
    private NewErrorData b = null;

    public void a(String str, String str2) {
        this.f1010a = new ap(c);
        this.f1010a.a(PushConstants.EXTRA_USER_ID, str);
        this.f1010a.a("com_id", str2);
        String j = this.f1010a.j();
        this.b = new NewErrorData();
        this.b.parserJson(j);
    }

    public void a() {
        if (this.f1010a != null) {
            this.f1010a.h();
        }
    }

    public boolean b() {
        if (this.f1010a != null) {
            return this.f1010a.c();
        }
        return false;
    }

    public String c() {
        if (this.f1010a != null) {
            return this.f1010a.g();
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
