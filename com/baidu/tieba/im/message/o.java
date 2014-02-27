package com.baidu.tieba.im.message;

import com.baidu.sapi2.shell.SapiErrorCode;
/* loaded from: classes.dex */
public final class o extends s {
    private int a = 0;
    private String b;

    public o() {
        e(SapiErrorCode.INVALID_ARG);
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final int b() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }
}
