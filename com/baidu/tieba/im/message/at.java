package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationReq;
/* loaded from: classes.dex */
public class at extends s implements com.baidu.tieba.im.coder.g {
    private String a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public at() {
        e(103009);
    }

    public void a(int i) {
        this.g = i;
    }

    public int b() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public int c() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int d() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public int e() {
        return this.c;
    }

    public void f(int i) {
        this.c = i;
    }

    public String f() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String g() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl.newBuilder().a(QueryGroupsByLocationReq.DataReq.newBuilder().a(com.baidu.adp.lib.f.b.a(g(), 0.0d)).b(com.baidu.adp.lib.f.b.a(f(), 0.0d)).c(e()).a(d()).b(c()).e(b()).d(b()).build()).build();
    }
}
