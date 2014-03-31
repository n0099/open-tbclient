package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryChatroomInfo.QueryChatroomInfoReq;
/* loaded from: classes.dex */
public final class z extends com.baidu.tbadk.message.websockt.d {
    private int a;

    public z() {
        super(106001);
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return QueryChatroomInfoReq.QueryChatroomInfoReqIdl.newBuilder().a(QueryChatroomInfoReq.DataReq.newBuilder().a(this.a).build()).build();
    }

    public final void d(int i) {
        this.a = i;
    }
}
