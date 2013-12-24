package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupsByUid.QueryGroupsByUidReq;
/* loaded from: classes.dex */
public class i extends n implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;

    public i(int i, int i2) {
        e(103003);
        this.a = i;
        this.b = i2;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryGroupsByUidReq.QueryGroupsByUidReqIdl.newBuilder().a(QueryGroupsByUidReq.DataReq.newBuilder().a(b()).b(c()).build()).build();
    }
}
