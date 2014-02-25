package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupsByFid.QueryGroupsByFidReq;
/* loaded from: classes.dex */
public class al extends s implements com.baidu.tieba.im.coder.g {
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;

    public al() {
        e(103002);
    }

    public int b() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public int c() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public String d() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String e() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String f() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String g() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryGroupsByFidReq.QueryGroupsByFidReqIdl.newBuilder().a(QueryGroupsByFidReq.DataReq.newBuilder().a(com.baidu.adp.lib.f.b.a(d(), 0)).c(com.baidu.adp.lib.f.b.a(f(), 0)).d(com.baidu.adp.lib.f.b.a(g(), 0)).b(com.baidu.adp.lib.f.b.a(e(), 0)).f(b()).e(c()).build()).build();
    }
}
