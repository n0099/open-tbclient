package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupDetail.QueryGroupDetailReq;
/* loaded from: classes.dex */
public final class ao extends s implements com.baidu.tieba.im.coder.g {
    private long a;
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;

    public ao() {
        e(103004);
    }

    public final long b() {
        return this.a;
    }

    public final void a(long j) {
        this.a = j;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final void d(int i) {
        this.e = i;
    }

    public final void a(String str) {
        this.f = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return QueryGroupDetailReq.QueryGroupDetailReqIdl.newBuilder().a(QueryGroupDetailReq.DataReq.newBuilder().d(this.d).e(this.e).b(this.b).c(this.c).a(this.f).a((int) this.a).build()).build();
    }
}
