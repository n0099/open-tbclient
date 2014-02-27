package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupsByUid.QueryGroupsByUidReq;
/* loaded from: classes.dex */
public final class m extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;

    public m(int i, int i2) {
        e(103003);
        this.a = i;
        this.b = i2;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return QueryGroupsByUidReq.QueryGroupsByUidReqIdl.newBuilder().a(QueryGroupsByUidReq.DataReq.newBuilder().a(this.a).b(this.b).build()).build();
    }
}
