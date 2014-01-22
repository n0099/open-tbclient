package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryChatroomInfo.QueryChatroomInfoReq;
/* loaded from: classes.dex */
public class ab extends q implements com.baidu.tieba.im.coder.g {
    private int a;

    public ab() {
        e(106001);
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryChatroomInfoReq.QueryChatroomInfoReqIdl.newBuilder().a(QueryChatroomInfoReq.DataReq.newBuilder().a(this.a).build()).build();
    }

    public void a(int i) {
        this.a = i;
    }
}
