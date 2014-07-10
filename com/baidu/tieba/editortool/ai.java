package com.baidu.tieba.editortool;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class ai {
    private ak a;
    private aj b;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private an g;
    private com.baidu.tbadk.editortool.w h;

    public abstract int a();

    public abstract void a(Context context);

    public abstract void b();

    public ai(an anVar) {
        this.g = anVar;
    }

    public ak c() {
        return this.a;
    }

    public void a(ak akVar) {
        this.a = akVar;
    }

    public aj d() {
        return this.b;
    }

    public void a(aj ajVar) {
        this.b = ajVar;
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

    public an i() {
        return this.g;
    }

    public com.baidu.tbadk.editortool.w j() {
        return this.h;
    }

    public void a(com.baidu.tbadk.editortool.w wVar) {
        this.h = wVar;
    }
}
