package com.baidu.tieba.im.message;

import com.baidu.sapi2.shell.SapiErrorCode;
/* loaded from: classes.dex */
public class db extends s {
    private String a;
    private String b;
    private int c = 0;

    public db() {
        e(SapiErrorCode.GETTING_CERT);
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public int c() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }
}
