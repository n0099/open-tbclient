package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryUserInfos.QueryUserInfosReq;
/* loaded from: classes.dex */
public class ax extends s implements com.baidu.tieba.im.coder.g {
    protobuf.QueryUserInfos.b a = QueryUserInfosReq.DataReq.newBuilder();

    public ax() {
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
