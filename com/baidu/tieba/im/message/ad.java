package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.DelGroup.DelGroupReq;
/* loaded from: classes.dex */
public final class ad extends com.baidu.tbadk.message.websockt.d {
    private int a;

    public ad() {
        super(103104);
    }

    public final void d(int i) {
        this.a = i;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return DelGroupReq.DelGroupReqIdl.newBuilder().a(DelGroupReq.DataReq.newBuilder().a(this.a).build()).build();
    }
}
