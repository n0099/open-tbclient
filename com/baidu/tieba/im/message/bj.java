package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupReq;
/* loaded from: classes.dex */
public final class bj extends com.baidu.tbadk.message.websockt.d {
    private long a;
    private int b;

    public bj() {
        super(103105);
        this.b = 1;
    }

    public final long i() {
        return this.a;
    }

    public final void a(boolean z) {
        this.b = 1;
    }

    public final void b(long j) {
        this.a = j;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl.newBuilder().a(UpgradeMemberGroupReq.DataReq.newBuilder().a((int) this.a).b(this.b).build()).build();
    }
}
