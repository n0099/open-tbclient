package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryUserInfos.QueryUserInfosReq;
/* loaded from: classes.dex */
public class am extends o implements com.baidu.tieba.im.coder.g {
    protobuf.QueryUserInfos.c a = QueryUserInfosReq.DataReq.newBuilder();

    public am() {
        e(205003);
    }

    public void a(long j) {
        this.a.a(j);
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryUserInfosReq.QueryUserInfosReqIdl.newBuilder().a(this.a.build()).build();
    }
}
