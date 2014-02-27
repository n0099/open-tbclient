package com.baidu.tieba.im.message;

import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.google.protobuf.MessageLite;
import protobuf.SearchGroup.SearchGroupReq;
/* loaded from: classes.dex */
public final class bb extends s implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    private int a;

    public bb() {
        e(103007);
    }

    public final int b() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public final IDuplicateProcess.RemoveState c() {
        return IDuplicateProcess.RemoveState.REMOVE_ME;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return SearchGroupReq.SearchGroupReqIdl.newBuilder().a(SearchGroupReq.DataReq.newBuilder().a(this.a).build()).build();
    }
}
