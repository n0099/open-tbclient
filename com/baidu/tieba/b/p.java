package com.baidu.tieba.b;

import android.content.Context;
import com.baidu.tieba.a.au;
/* loaded from: classes.dex */
public class p {
    private long d;
    private long e;
    private long f;
    private String g;
    private com.baidu.tieba.c.a i;
    private boolean a = true;
    private String b = null;
    private int c = 0;
    private au j = null;
    private boolean h = false;

    public p(Context context) {
        a(0L);
        b(0L);
        c(0L);
        this.i = new com.baidu.tieba.c.a(context);
    }

    public String a() {
        return this.b;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(long j) {
        this.d = j;
    }

    public void a(au auVar) {
        this.j = auVar;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void b(long j) {
        this.e = j;
    }

    public void b(String str) {
        this.g = str;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public boolean b() {
        return this.a;
    }

    public int c() {
        return this.c;
    }

    public void c(long j) {
        this.f = j;
    }

    public au d() {
        return this.j;
    }

    public com.baidu.tieba.c.a e() {
        return this.i;
    }

    public String f() {
        return this.g;
    }

    public long g() {
        return this.d;
    }

    public long h() {
        return this.e + this.f;
    }

    public boolean i() {
        return this.h;
    }
}
