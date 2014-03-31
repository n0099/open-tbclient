package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.DelGroupActivity.DelGroupActivityReq;
/* loaded from: classes.dex */
public final class ac extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private long b;

    public ac() {
        super(103121);
    }

    public final void d(int i) {
        this.a = i;
    }

    public final void b(long j) {
        this.b = j;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return DelGroupActivityReq.DelGroupActivityReqIdl.newBuilder().a(DelGroupActivityReq.DataReq.newBuilder().b(this.a).a((int) this.b).build()).build();
    }
}
