package com.baidu.tieba.a;

import java.io.Serializable;
/* loaded from: classes.dex */
public class an implements Serializable {
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;

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
        if (str != null) {
            str = com.baidu.tieba.c.af.b(str.getBytes());
        }
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public void e(String str) {
        this.f = str;
    }

    public String e() {
        return this.f;
    }

    public void a(int i) {
        this.e = i;
    }

    public int f() {
        return this.e;
    }
}
