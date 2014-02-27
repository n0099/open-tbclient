package com.baidu.tieba.im.message;

import com.baidu.sapi2.shell.SapiErrorCode;
/* loaded from: classes.dex */
public final class p extends da {
    private String a;
    private String b;

    public p() {
        e(SapiErrorCode.INVALID_ARG);
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }
}
