package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.bg;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.a.d {
    private int c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l;
    private com.baidu.tieba.im.message.aa a = null;
    private bg b = null;
    private int m = -1;

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public void d(String str) {
        this.g = str;
    }

    public void e(String str) {
        this.h = str;
    }

    public void f(String str) {
        this.i = str;
    }

    public void g(String str) {
        this.j = str;
    }

    public void b(int i) {
        this.k = i;
    }

    public void c(int i) {
        this.l = i;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void d(int i) {
        this.m = i;
    }

    private com.baidu.tieba.im.message.aa c() {
        com.baidu.tieba.im.message.aa aaVar = new com.baidu.tieba.im.message.aa();
        aaVar.a(this.c);
        aaVar.a(this.d);
        aaVar.b(this.e);
        aaVar.c(this.f);
        aaVar.d(this.g);
        aaVar.e(this.h);
        aaVar.f(this.i);
        aaVar.g(this.j);
        aaVar.b(this.k);
        aaVar.c(this.l);
        switch (this.m) {
            case 1011:
                aaVar.h("neargp");
                break;
            case 1012:
                aaVar.h("mygp");
                break;
            case 1013:
                aaVar.h("bargp");
                break;
            case 1014:
                aaVar.h("");
                break;
            default:
                aaVar.h("");
                break;
        }
        return aaVar;
    }

    public void a() {
        this.a = c();
        com.baidu.tieba.im.messageCenter.e.a().a(this.a);
    }

    public void b() {
        if (this.a != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.a);
            this.a = null;
        }
        if (this.b != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.b);
            this.b = null;
        }
    }
}
