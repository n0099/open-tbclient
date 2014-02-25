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

    public int e() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int f() {
        return this.a;
    }

    public void b(int i) {
        this.a = i;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public IDuplicateProcess.RemoveState h() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public boolean a(s sVar) {
        return true;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        protobuf.k newBuilder = Im.GroupInfo.newBuilder();
        newBuilder.a(e());
        a(newBuilder);
        return UpdateGroupReq.UpdateGroupReqIdl.newBuilder().a(newBuilder.build()).build();
    }
}
