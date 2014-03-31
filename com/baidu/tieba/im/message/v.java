package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CommitPusherCount.CommitPusherCountReq;
/* loaded from: classes.dex */
public final class v extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private long b;
    private long c;
    private int d;

    public final void d(int i) {
        this.d = i;
    }

    public final void e(int i) {
        this.a = i;
    }

    public final void b(long j) {
        this.b = j;
    }

    public final void c(long j) {
        this.c = j;
    }

    public v() {
        super(202101);
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return CommitPusherCountReq.CommitPusherCountReqIdl.newBuilder().a(CommitPusherCountReq.DataReq.newBuilder().c(this.c).a(this.a).b(this.b).build()).build();
    }
}
