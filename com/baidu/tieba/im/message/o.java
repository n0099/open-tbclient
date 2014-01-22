package com.baidu.tieba.im.message;

import com.baidu.sapi2.shell.SapiErrorCode;
/* loaded from: classes.dex */
public class o extends q {
    private String a;
    private String b;
    private int c;
    private String d;
    private long e;
    private int f = 0;

    public o() {
        e(SapiErrorCode.GET_CERT_FAIL);
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

    public String d() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public long e() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public int f() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }
}
