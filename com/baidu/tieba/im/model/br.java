package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
/* loaded from: classes.dex */
public final class br extends com.baidu.adp.a.e {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g = null;
    private int h = 0;
    private com.baidu.tieba.im.message.bg i;
    private ResponseUpdateGroupMessage j;

    public final void a(int i) {
        this.a = i;
    }

    public final void a(long j) {
        this.a = (int) j;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final void c(String str) {
        this.d = str;
    }

    public final String a() {
        return this.e;
    }

    public final void d(String str) {
        this.e = str;
    }

    public final String b() {
        return this.f;
    }

    public final void e(String str) {
        this.f = str;
    }

    public final void f(String str) {
        this.g = str;
    }

    public final int c() {
        return this.h;
    }

    public final void b(int i) {
        this.h = i;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void c(int i) {
        com.baidu.tieba.im.message.bg bgVar = null;
        switch (i) {
            case 1:
                bgVar = new com.baidu.tieba.im.message.bf(this.c);
                break;
            case 2:
                bgVar = new com.baidu.tieba.im.message.bh(this.b);
                break;
            case 3:
                bgVar = new com.baidu.tieba.im.message.bd(this.g);
                break;
            case 4:
                bgVar = new com.baidu.tieba.im.message.bi(this.d);
                break;
            case 5:
                bgVar = new com.baidu.tieba.im.message.be(this.h, this.e, this.f);
            default:
                com.baidu.adp.lib.util.f.b("no right type");
                break;
        }
        if (bgVar != null) {
            bgVar.d(this.a);
            bgVar.e(i);
        }
        this.i = bgVar;
        super.sendMessage(this.i);
    }

    @Override // com.baidu.adp.a.e
    public final void cancelMessage() {
        this.i = null;
        this.j = null;
        super.cancelMessage();
    }
}
