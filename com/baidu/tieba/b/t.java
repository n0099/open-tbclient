package com.baidu.tieba.b;

import android.content.Context;
import com.baidu.tieba.a.az;
/* loaded from: classes.dex */
public class t {
    private long d;
    private long e;
    private long f;
    private String g;
    private com.baidu.tieba.c.a j;
    private boolean a = true;
    private String b = null;
    private int c = 0;
    private az k = null;
    private boolean h = false;
    private boolean i = false;

    public t(Context context) {
        a(0L);
        b(0L);
        c(0L);
        this.j = new com.baidu.tieba.c.a(context);
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean b() {
        return this.a;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(az azVar) {
        this.k = azVar;
    }

    public az c() {
        return this.k;
    }

    public com.baidu.tieba.c.a d() {
        return this.j;
    }

    public void b(String str) {
        this.g = str;
    }

    public String e() {
        return this.g;
    }

    public void a(long j) {
        this.d = j;
    }

    public long f() {
        return this.d;
    }

    public void b(long j) {
        this.e = j;
    }

    public long g() {
        return this.e + this.f;
    }

    public void c(long j) {
        this.f = j;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public boolean h() {
        return this.h;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public boolean i() {
        return this.i;
    }
}
