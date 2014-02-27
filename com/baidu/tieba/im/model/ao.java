package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.bd;
import com.baidu.tieba.im.message.be;
import com.baidu.tieba.im.message.bf;
import com.baidu.tieba.im.message.bg;
import com.baidu.tieba.im.message.bh;
import com.baidu.tieba.im.message.bi;
import com.baidu.tieba.im.message.cw;
/* loaded from: classes.dex */
public final class ao extends com.baidu.adp.a.d {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g = null;
    private int h = 0;
    private bg i;
    private cw j;

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

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final void c(int i) {
        bg bgVar = null;
        switch (i) {
            case 1:
                bgVar = new bf(this.c);
                break;
            case 2:
                bgVar = new bh(this.b);
                break;
            case 3:
                bgVar = new bd(this.g);
                break;
            case 4:
                bgVar = new bi(this.d);
                break;
            case 5:
                bgVar = new be(this.h, this.e, this.f);
            default:
                com.baidu.adp.lib.util.e.b("no right type");
                break;
        }
        if (bgVar != null) {
            bgVar.a(this.a);
            bgVar.a = i;
        }
        this.i = bgVar;
        com.baidu.tieba.im.messageCenter.d.a().a(this.i);
    }

    public final void d() {
        if (this.i != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.i);
            this.i = null;
        }
        if (this.j != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.j);
            this.j = null;
        }
    }
}
