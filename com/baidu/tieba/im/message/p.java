package com.baidu.tieba.im.message;

import com.baidu.sapi2.shell.SapiErrorCode;
/* loaded from: classes.dex */
public class p extends da {
    private String a;
    private String b;

    public p() {
        e(SapiErrorCode.INVALID_ARG);
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }
}
