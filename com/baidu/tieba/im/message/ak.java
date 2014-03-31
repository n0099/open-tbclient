package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupDetail.QueryGroupDetailReq;
/* loaded from: classes.dex */
public final class ak extends com.baidu.tbadk.message.websockt.d {
    private long a;
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;

    public ak() {
        super(103004);
    }

    public final void b(long j) {
        this.a = j;
    }

    public final void d(int i) {
        this.b = i;
    }

    public final void e(int i) {
        this.c = i;
    }

    public final void f(int i) {
        this.d = i;
    }

    public final void h(int i) {
        this.e = i;
    }

    public final void a(String str) {
        this.f = str;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return QueryGroupDetailReq.QueryGroupDetailReqIdl.newBuilder().a(QueryGroupDetailReq.DataReq.newBuilder().d(this.d).e(this.e).b(this.b).c(this.c).a(this.f).a((int) this.a).build()).build();
    }
}
