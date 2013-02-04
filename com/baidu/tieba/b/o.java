package com.baidu.tieba.b;

import java.io.Serializable;
/* loaded from: classes.dex */
public class o implements Serializable {
    private String a = null;
    private int b = 1;
    private String c = null;
    private String d = null;
    private boolean e = false;

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public int b() {
        return this.b;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public boolean d() {
        return this.e;
    }

    public String e() {
        return this.d;
    }
}
