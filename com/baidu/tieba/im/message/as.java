package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupUserList.QueryGroupUserListReq;
/* loaded from: classes.dex */
public final class as extends s implements com.baidu.tieba.im.coder.g {
    private long a;
    private int b;
    private int c;
    private int d;

    public as() {
        e(103005);
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

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return QueryGroupUserListReq.QueryGroupUserListReqIdl.newBuilder().a(QueryGroupUserListReq.DataReq.newBuilder().a((int) this.a).b(this.b).d(this.d).c(this.c).build()).build();
    }
}
