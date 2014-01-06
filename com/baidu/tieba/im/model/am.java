package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.aq;
import com.baidu.tieba.im.message.ar;
import com.baidu.tieba.im.message.as;
import com.baidu.tieba.im.message.at;
import com.baidu.tieba.im.message.au;
import com.baidu.tieba.im.message.av;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.a.d {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g = null;
    private int h = 0;
    private at i;
    private bz j;

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(long j) {
        this.a = (int) j;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public String d() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public String f() {
        return this.f;
    }

    public void e(String str) {
        this.f = str;
    }

    public String g() {
        return this.g;
    }

    public void f(String str) {
        this.g = str;
    }

    public int h() {
        return this.h;
    }

    public void b(int i) {
        this.h = i;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    private at d(int i) {
        at atVar = null;
        switch (i) {
            case 1:
                atVar = new as(c());
                break;
            case 2:
                atVar = new au(b());
                break;
            case 3:
                atVar = new aq(g());
                break;
            case 4:
                atVar = new av(d());
                break;
            case 5:
                atVar = new ar(h(), e(), f());
            default:
                com.baidu.adp.lib.h.e.a("no right type");
                break;
        }
        if (atVar != null) {
            atVar.a(a());
            atVar.b(i);
        }
        return atVar;
    }

    public void c(int i) {
        this.i = d(i);
        com.baidu.tieba.im.messageCenter.e.a().a(this.i);
    }

    public void i() {
        if (this.i != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.i);
            this.i = null;
        }
        if (this.j != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.j);
            this.j = null;
        }
    }
}
