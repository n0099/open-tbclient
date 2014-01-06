package com.baidu.tieba.im.message;

import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.google.protobuf.MessageLite;
import protobuf.QueryUserPermission.QueryUserPermissionReq;
/* loaded from: classes.dex */
public class ax extends o implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    private long a;

    public ax() {
        e(103008);
    }

    public long b() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryUserPermissionReq.QueryUserPermissionReqIdl.newBuilder().a(QueryUserPermissionReq.DataReq.newBuilder().a((int) b()).build()).build();
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public IDuplicateProcess.RemoveState h() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public boolean a(o oVar) {
        return true;
    }
}
