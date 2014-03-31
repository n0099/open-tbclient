package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupsByUid.QueryGroupsByUidReq;
/* loaded from: classes.dex */
public final class f extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private int b;

    public f(int i, int i2) {
        super(103003);
        this.a = i;
        this.b = i2;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return QueryGroupsByUidReq.QueryGroupsByUidReqIdl.newBuilder().a(QueryGroupsByUidReq.DataReq.newBuilder().a(this.a).b(this.b).build()).build();
    }
}
