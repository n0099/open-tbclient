package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryUserInfos.QueryUserInfosReq;
/* loaded from: classes.dex */
public final class at extends com.baidu.tbadk.message.websockt.d {
    protobuf.QueryUserInfos.b a;

    public at() {
        super(205003);
        this.a = QueryUserInfosReq.DataReq.newBuilder();
    }

    public final void b(long j) {
        this.a.a(j);
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return QueryUserInfosReq.QueryUserInfosReqIdl.newBuilder().a(this.a.build()).build();
    }
}
