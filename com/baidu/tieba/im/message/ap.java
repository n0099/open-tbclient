package com.baidu.tieba.im.message;

import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.google.protobuf.MessageLite;
import protobuf.SearchGroup.SearchGroupReq;
/* loaded from: classes.dex */
public class ap extends o implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    private int a;

    public ap() {
        e(103007);
    }

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public IDuplicateProcess.RemoveState h() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public boolean a(o oVar) {
        return true;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return SearchGroupReq.SearchGroupReqIdl.newBuilder().a(SearchGroupReq.DataReq.newBuilder().a(b()).build()).build();
    }
}
