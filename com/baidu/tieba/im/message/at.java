package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupsByLocation.QueryGroupsByLocationReq;
/* loaded from: classes.dex */
public final class at extends s implements com.baidu.tieba.im.coder.g {
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

    public final void a(int i) {
        this.g = i;
    }

    public final void b(int i) {
        this.f = i;
    }

    public final void c(int i) {
        this.e = 30;
    }

    public final void d(int i) {
        this.d = i;
    }

    public final void f(int i) {
        this.c = i;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void b(String str) {
        this.b = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return QueryGroupsByLocationReq.QueryGroupsByLocationReqIdl.newBuilder().a(QueryGroupsByLocationReq.DataReq.newBuilder().a(com.baidu.adp.lib.f.b.a(this.b, 0.0d)).b(com.baidu.adp.lib.f.b.a(this.a, 0.0d)).c(this.c).a(this.d).b(this.e).e(this.f).d(this.f).build()).build();
    }
}
