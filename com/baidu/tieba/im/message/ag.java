package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupsByFid.QueryGroupsByFidReq;
/* loaded from: classes.dex */
public final class ag extends com.baidu.tbadk.message.websockt.d {
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;

    public ag() {
        super(103002);
    }

    public final void d(int i) {
        this.e = i;
    }

    public final void e(int i) {
        this.f = i;
    }

    public final String i() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String j() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final void d(String str) {
        this.d = str;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return QueryGroupsByFidReq.QueryGroupsByFidReqIdl.newBuilder().a(QueryGroupsByFidReq.DataReq.newBuilder().a(com.baidu.adp.lib.f.b.a(this.a, 0)).c(com.baidu.adp.lib.f.b.a(this.c, 0)).d(com.baidu.adp.lib.f.b.a(this.d, 0)).b(com.baidu.adp.lib.f.b.a(this.b, 0)).f(this.e).e(this.f).build()).build();
    }
}
