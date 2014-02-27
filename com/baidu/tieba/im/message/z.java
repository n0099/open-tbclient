package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CommitPusherCount.CommitPusherCountReq;
/* loaded from: classes.dex */
public final class z extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private long b;
    private long c;
    private int d;

    public final void a(int i) {
        this.d = i;
    }

    public final void b(int i) {
        this.a = i;
    }

    public final void a(long j) {
        this.b = j;
    }

    public final void b(long j) {
        this.c = j;
    }

    public z() {
        e(202101);
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return CommitPusherCountReq.CommitPusherCountReqIdl.newBuilder().a(CommitPusherCountReq.DataReq.newBuilder().c(this.c).a(this.a).b(this.b).build()).build();
    }
}
