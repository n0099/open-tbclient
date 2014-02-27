package com.baidu.tieba.b;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.l;
/* loaded from: classes.dex */
public final class e extends l {
    private static final String c = String.valueOf(com.baidu.tieba.data.i.a) + "c/u/user/get_double_follows";
    private static final String d = String.valueOf(com.baidu.tieba.data.i.a) + "c/u/user/search_double_follows";

    public final String b(String str) {
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
    @Override // com.baidu.tieba.l
    public final String b() {
        String l = this.a.l();
        if (this.a.c()) {
            this.b = new NewErrorData();
            this.b.parserJson(l);
        } else {
            this.b = new NewErrorData();
            this.b.errmsg = this.a.i();
            this.b.errno = this.a.e();
        }
        return l;
    }

    @Override // com.baidu.tieba.l
    public final void a() {
        if (this.a != null) {
            this.a.j();
        }
    }

    public final String g() {
        if (this.b != null) {
            return this.b.getErrorMsg();
        }
        return null;
    }

    @Override // com.baidu.tieba.l
    public final int e() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        return 0;
    }
}
