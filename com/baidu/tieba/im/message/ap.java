package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupGrade.QueryGroupGradeReq;
/* loaded from: classes.dex */
public final class ap extends s implements com.baidu.tieba.im.coder.g {
    private long a;

    public ap() {
        e(103006);
    }

    public final void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return QueryGroupGradeReq.QueryGroupGradeReqIdl.newBuilder().a(QueryGroupGradeReq.DataReq.newBuilder().a((int) this.a).build()).build();
    }
}
