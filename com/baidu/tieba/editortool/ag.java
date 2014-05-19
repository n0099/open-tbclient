package com.baidu.tieba.editortool;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class ag {
    private ai a;
    private ah b;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private al g;
    private com.baidu.tbadk.editortool.x h;

    public abstract int a();

    public abstract void a(Context context);

    public abstract void b();

    public ag(al alVar) {
        this.g = alVar;
    }

    public ai c() {
        return this.a;
    }

    public void a(ai aiVar) {
        this.a = aiVar;
    }

    public ah d() {
        return this.b;
    }

    public void a(ah ahVar) {
        this.b = ahVar;
    }

    public int e() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public int f() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public int g() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int h() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    public al i() {
        return this.g;
    }

    public com.baidu.tbadk.editortool.x j() {
        return this.h;
    }

    public void a(com.baidu.tbadk.editortool.x xVar) {
        this.h = xVar;
    }
}
