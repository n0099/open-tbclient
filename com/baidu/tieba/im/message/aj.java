package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.DelGroup.DelGroupReq;
/* loaded from: classes.dex */
public final class aj extends s implements com.baidu.tieba.im.coder.g {
    private int a;

    public aj() {
        e(103104);
    }

    public final void a(int i) {
        this.a = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return DelGroupReq.DelGroupReqIdl.newBuilder().a(DelGroupReq.DataReq.newBuilder().a(this.a).build()).build();
    }
}
