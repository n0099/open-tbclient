package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupGrade.QueryGroupGradeReq;
/* loaded from: classes.dex */
public final class al extends com.baidu.tbadk.message.websockt.d {
    private long a;

    public al() {
        super(103006);
    }

    public final void b(long j) {
        this.a = j;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return QueryGroupGradeReq.QueryGroupGradeReqIdl.newBuilder().a(QueryGroupGradeReq.DataReq.newBuilder().a((int) this.a).build()).build();
    }
}
