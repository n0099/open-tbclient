package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupUserList.QueryGroupUserListReq;
/* loaded from: classes.dex */
public final class ap extends com.baidu.tbadk.message.websockt.d {
    private long a;
    private int b;
    private int c;
    private int d;

    public ap() {
        super(103005);
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

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return QueryGroupUserListReq.QueryGroupUserListReqIdl.newBuilder().a(QueryGroupUserListReq.DataReq.newBuilder().a((int) this.a).b(this.b).d(this.d).c(this.c).build()).build();
    }
}
