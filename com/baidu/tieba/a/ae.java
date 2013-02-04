package com.baidu.tieba.a;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ae implements Serializable {
    private String a;
    private String d;
    private String l;
    private String m;
    private String n;
    private String b = null;
    private int c = 0;
    private long e = 0;
    private String h = null;
    private boolean f = true;
    private boolean g = false;
    private String i = null;
    private int j = 0;
    private int k = 0;

    public String a() {
        return this.i;
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(Boolean bool) {
        this.f = bool.booleanValue();
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public int b() {
        return this.j;
    }

    public void b(int i) {
        this.k = i;
    }

    public void b(String str) {
        this.b = str;
    }

    public int c() {
        return this.k;
    }

    public void c(int i) {
        this.c = i;
    }

    public void c(String str) {
        this.h = str;
    }

    public String d() {
        return this.b;
    }

    public void d(String str) {
        this.d = str;
    }

    public int e() {
        return this.c;
    }

    public void e(String str) {
        this.a = str;
    }

    public long f() {
        return this.e;
    }

    public void f(String str) {
        this.l = str;
    }

    public String g() {
        return this.h;
    }

    public void g(String str) {
        this.m = str;
    }

    public Boolean h() {
        return Boolean.valueOf(this.f);
    }

    public void h(String str) {
        this.n = str;
    }

    public boolean i() {
        return this.g;
    }

    public String j() {
        return this.d;
    }

    public String k() {
        return this.l;
    }

    public String l() {
        return this.m;
    }

    public String m() {
        return this.n;
    }
}
