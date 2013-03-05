package com.baidu.tieba.b;

import android.content.Context;
import com.baidu.tieba.a.av;
/* loaded from: classes.dex */
public class s {
    private long d;
    private long e;
    private long f;
    private String g;
    private com.baidu.tieba.c.a j;
    private boolean a = true;
    private String b = null;
    private int c = 0;
    private av k = null;
    private boolean h = false;
    private boolean i = false;

    public s(Context context) {
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

    public int c() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(av avVar) {
        this.k = avVar;
    }

    public av d() {
        return this.k;
    }

    public com.baidu.tieba.c.a e() {
        return this.j;
    }

    public void b(String str) {
        this.g = str;
    }

    public String f() {
        return this.g;
    }

    public void a(long j) {
        this.d = j;
    }

    public long g() {
        return this.d;
    }

    public void b(long j) {
        this.e = j;
    }

    public long h() {
        return this.e + this.f;
    }

    public void c(long j) {
        this.f = j;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public boolean i() {
        return this.h;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public boolean j() {
        return this.i;
    }
}
