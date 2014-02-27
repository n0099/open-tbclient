package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupReq;
/* loaded from: classes.dex */
public final class bk extends s implements com.baidu.tieba.im.coder.g {
    private long a;
    private int b = 1;

    public bk() {
        e(103105);
    }

    public final long b() {
        return this.a;
    }

    public final void a(boolean z) {
        this.b = 1;
    }

    public final void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return UpgradeMemberGroupReq.UpgradeMemberGroupReqIdl.newBuilder().a(UpgradeMemberGroupReq.DataReq.newBuilder().a((int) this.a).b(this.b).build()).build();
    }
}
