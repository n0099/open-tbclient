package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.ax;
import com.baidu.tieba.im.message.ay;
import com.baidu.tieba.im.message.az;
import com.baidu.tieba.im.message.ba;
import com.baidu.tieba.im.message.bb;
import com.baidu.tieba.im.message.bc;
import com.baidu.tieba.im.message.cn;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.a.d {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g = null;
    private int h = 0;
    private ba i;
    private cn j;

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

    private ba d(int i) {
        ba baVar = null;
        switch (i) {
            case 1:
                baVar = new az(c());
                break;
            case 2:
                baVar = new bb(b());
                break;
            case 3:
                baVar = new ax(g());
                break;
            case 4:
                baVar = new bc(d());
                break;
            case 5:
                baVar = new ay(h(), e(), f());
            default:
                com.baidu.adp.lib.g.e.a("no right type");
                break;
        }
        if (baVar != null) {
            baVar.a(a());
            baVar.b(i);
        }
        return baVar;
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
