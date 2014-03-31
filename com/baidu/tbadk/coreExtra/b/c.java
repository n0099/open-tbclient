package com.baidu.tbadk.coreExtra.b;

import java.util.HashMap;
import java.util.Set;
/* loaded from: classes.dex */
public final class c {
    private String k;
    private String l;
    private String m;
    private String n;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private boolean j = true;
    private HashMap<String, String> o = new HashMap<>();
    private HashMap<String, String> p = new HashMap<>();

    public final void a() {
        HashMap<String, String> hashMap = this.o;
        Set<String> keySet = hashMap.keySet();
        if (keySet.size() != 1) {
            this.q = null;
        } else {
            this.q = hashMap.get(keySet.iterator().next());
        }
    }

    public final void b() {
        HashMap<String, String> hashMap = this.p;
        Set<String> keySet = hashMap.keySet();
        if (keySet.size() != 1) {
            this.t = null;
        } else {
            this.t = hashMap.get(keySet.iterator().next());
        }
    }

    public final int c() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final int d() {
        return this.c;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final int e() {
        return this.d;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final int f() {
        return this.f;
    }

    public final void d(int i) {
        this.f = i;
    }

    public final int g() {
        return this.i;
    }

    public final void e(int i) {
        this.i = i;
    }

    public final String h() {
        return this.w;
    }

    public final void a(String str) {
        this.w = str;
    }

    public final String i() {
        return this.x;
    }

    public final void b(String str) {
        this.x = str;
    }

    public final int j() {
        return this.b;
    }

    public final void f(int i) {
        this.b = i;
    }

    public final boolean k() {
        return this.j;
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final String l() {
        return this.k;
    }

    public final void c(String str) {
        this.k = str;
    }

    public final String m() {
        return this.q;
    }

    public final void d(String str) {
        this.r = str;
    }

    public final void e(String str) {
        this.s = str;
    }

    public final String n() {
        return this.u;
    }

    public final void f(String str) {
        this.u = str;
    }

    public final String o() {
        return this.v;
    }

    public final void g(String str) {
        this.v = str;
    }

    public final HashMap<String, String> p() {
        return this.o;
    }

    public final int q() {
        return this.e;
    }

    public final void g(int i) {
        this.e = i;
    }

    public final int r() {
        return this.g;
    }

    public final void h(int i) {
        this.g = i;
    }

    public final void h(String str) {
        this.l = str;
    }

    public final void i(String str) {
        this.m = str;
    }

    public final int s() {
        return this.h;
    }

    public final void i(int i) {
        this.h = i;
    }

    public final String t() {
        return this.n;
    }

    public final void j(String str) {
        this.n = str;
    }

    public final HashMap<String, String> u() {
        return this.p;
    }

    public final String v() {
        return this.t;
    }
}
