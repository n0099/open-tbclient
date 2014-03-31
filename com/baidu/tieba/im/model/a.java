package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.ResponseAddGroupMessage;
/* loaded from: classes.dex */
public final class a extends com.baidu.adp.a.e {
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
    private com.baidu.tieba.im.message.y a = null;
    private ResponseAddGroupMessage b = null;
    private int m = -1;

    public final void a(int i) {
        this.c = i;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final void c(String str) {
        this.f = str;
    }

    public final void d(String str) {
        this.g = str;
    }

    public final void e(String str) {
        this.h = str;
    }

    public final void f(String str) {
        this.i = str;
    }

    public final void g(String str) {
        this.j = str;
    }

    public final void b(int i) {
        this.k = i;
    }

    public final void c(int i) {
        this.l = i;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void d(int i) {
        this.m = i;
    }

    public final void a() {
        com.baidu.tieba.im.message.y yVar = new com.baidu.tieba.im.message.y();
        yVar.d(this.c);
        yVar.a(this.d);
        yVar.b(this.e);
        yVar.c(this.f);
        yVar.d(this.g);
        yVar.e(this.h);
        yVar.f(this.i);
        yVar.g(this.j);
        yVar.e(this.k);
        yVar.f(this.l);
        switch (this.m) {
            case 1011:
                yVar.h("neargp");
                break;
            case 1012:
                yVar.h("mygp");
                break;
            case 1013:
                yVar.h("bargp");
                break;
            case 1014:
                yVar.h("");
                break;
            default:
                yVar.h("");
                break;
        }
        this.a = yVar;
        super.sendMessage(this.a);
    }

    @Override // com.baidu.adp.a.e
    public final void cancelMessage() {
        super.cancelMessage();
    }
}
