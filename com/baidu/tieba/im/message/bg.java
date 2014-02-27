package com.baidu.tieba.im.message;

import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.google.protobuf.MessageLite;
import protobuf.Im;
import protobuf.UpdateGroup.UpdateGroupReq;
/* loaded from: classes.dex */
public abstract class bg extends s implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    public int a;
    private int b;

    protected abstract void a(protobuf.k kVar);

    public bg() {
        e(103102);
    }

    public final void a(int i) {
        this.b = i;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public final IDuplicateProcess.RemoveState c() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        protobuf.k newBuilder = Im.GroupInfo.newBuilder();
        newBuilder.a(this.b);
        a(newBuilder);
        return UpdateGroupReq.UpdateGroupReqIdl.newBuilder().a(newBuilder.build()).build();
    }
}
