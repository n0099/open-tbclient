package com.baidu.tieba.im.message;

import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.google.protobuf.MessageLite;
import protobuf.QueryUserPermission.QueryUserPermissionReq;
/* loaded from: classes.dex */
public final class bl extends s implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    private long a;

    public bl() {
        e(103008);
    }

    public final void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return QueryUserPermissionReq.QueryUserPermissionReqIdl.newBuilder().a(QueryUserPermissionReq.DataReq.newBuilder().a((int) this.a).build()).build();
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public final IDuplicateProcess.RemoveState c() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }
}
