package com.baidu.tieba.im.friend;

import com.baidu.tbadk.core.data.NewErrorData;
/* loaded from: classes.dex */
final class a extends com.baidu.tbadk.core.f {
    private static final String c = String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/u/user/get_double_follows";
    private static final String d = String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/u/user/search_double_follows";

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b(String str) {
        if (str == null || str.trim().equals("")) {
            a(c);
        } else {
            a(d);
            this.a.a("user_name", str);
        }
        this.a.a("offset", "0");
        this.a.a("limit", String.valueOf(100));
        String b = b();
        if (!c()) {
            return null;
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.f
    public final String b() {
        String i = this.a.i();
        if (this.a.a().b().b()) {
            this.b = new NewErrorData();
            this.b.parserJson(i);
        } else {
            this.b = new NewErrorData();
            this.b.errmsg = this.a.f();
            this.b.errno = this.a.d();
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.f
    public final void a() {
        if (this.a != null) {
            this.a.g();
        }
    }

    public final String g() {
        if (this.b != null) {
            return this.b.getErrorMsg();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.f
    public final int e() {
        if (this.b != null) {
            return this.b.getErrorNumber();
        }
        return 0;
    }
}
