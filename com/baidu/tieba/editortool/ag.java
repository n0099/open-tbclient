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

    public final ai c() {
        return this.a;
    }

    public final void a(ai aiVar) {
        this.a = aiVar;
    }

    public final ah d() {
        return this.b;
    }

    public final void a(ah ahVar) {
        this.b = ahVar;
    }

    public final int e() {
        return this.c;
    }

    public final void a(int i) {
        this.c = 2;
    }

    public final int f() {
        return this.d;
    }

    public final void b(int i) {
        this.d = 2;
    }

    public final int g() {
        return this.e;
    }

    public final void c(int i) {
        this.e = i;
    }

    public final int h() {
        return this.f;
    }

    public final void d(int i) {
        this.f = i;
    }

    public final al i() {
        return this.g;
    }

    public final com.baidu.tbadk.editortool.x j() {
        return this.h;
    }

    public final void a(com.baidu.tbadk.editortool.x xVar) {
        this.h = xVar;
    }
}
