package com.baidu.tieba.im.message;

import com.baidu.sapi2.shell.SapiErrorCode;
/* loaded from: classes.dex */
public final class db extends s {
    private String a;
    private String b;
    private int c = 0;

    public db() {
        e(SapiErrorCode.GETTING_CERT);
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final String b() {
        return this.a;
    }

    public final void b(String str) {
        this.a = str;
    }

    public final int c() {
        return this.c;
    }

    public final void a(int i) {
        this.c = i;
    }
}
