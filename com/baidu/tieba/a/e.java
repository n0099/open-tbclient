package com.baidu.tieba.a;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends n {
    private static final String c = com.baidu.tieba.data.h.a + "c/u/user/get_double_follows";
    private static final String d = com.baidu.tieba.data.h.a + "c/u/user/search_double_follows";

    public String b(String str) {
        if (str == null || str.trim().equals("")) {
            a(c);
        } else {
            a(d);
            this.a.a("user_name", str);
        }
        this.a.a("offset", SocialConstants.FALSE);
        this.a.a("limit", String.valueOf(100));
        String b = b();
        if (!c()) {
            return null;
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.n
    public String b() {
        String m = this.a.m();
        if (this.a.d()) {
            this.b = new NewErrorData();
            this.b.parserJson(m);
        } else {
            this.b = new NewErrorData();
            this.b.errmsg = this.a.j();
            this.b.errno = this.a.f();
        }
        return m;
    }

    @Override // com.baidu.tieba.n
    public void a() {
        if (this.a != null) {
            this.a.k();
        }
    }

    public String g() {
        if (this.b != null) {
            return this.b.getErrorMsg();
        }
        return null;
    }

    @Override // com.baidu.tieba.n
    public int e() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        return 0;
    }
}
