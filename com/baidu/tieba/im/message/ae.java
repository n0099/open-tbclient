package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryChatroomInfo.QueryChatroomInfoReq;
/* loaded from: classes.dex */
public final class ae extends s implements com.baidu.tieba.im.coder.g {
    private int a;

    public ae() {
        e(106001);
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return QueryChatroomInfoReq.QueryChatroomInfoReqIdl.newBuilder().a(QueryChatroomInfoReq.DataReq.newBuilder().a(this.a).build()).build();
    }

    public final void a(int i) {
        this.a = i;
    }
}
