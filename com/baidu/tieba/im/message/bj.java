package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryUserPermission.QueryUserPermissionReq;
/* loaded from: classes.dex */
public final class bj extends com.baidu.tbadk.message.websockt.d {
    private long a;

    public bj() {
        super(103008);
    }

    public final void b(long j) {
        this.a = j;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return QueryUserPermissionReq.QueryUserPermissionReqIdl.newBuilder().a(QueryUserPermissionReq.DataReq.newBuilder().a((int) this.a).build()).build();
    }
}
