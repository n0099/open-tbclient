package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.UpdateGroup.UpdateGroupReq;
/* loaded from: classes.dex */
public abstract class bg extends com.baidu.tbadk.message.websockt.d {
    public int a;
    private int b;

    protected abstract void a(protobuf.k kVar);

    public bg() {
        super(103102);
    }

    public final void d(int i) {
        this.b = i;
    }

    public final int i() {
        return this.a;
    }

    public final void e(int i) {
        this.a = i;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        protobuf.k newBuilder = Im.GroupInfo.newBuilder();
        newBuilder.a(this.b);
        a(newBuilder);
        return UpdateGroupReq.UpdateGroupReqIdl.newBuilder().a(newBuilder.build()).build();
    }
}
