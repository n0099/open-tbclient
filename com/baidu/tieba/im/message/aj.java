package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupGrade.QueryGroupGradeReq;
/* loaded from: classes.dex */
public class aj extends q implements com.baidu.tieba.im.coder.g {
    private long a;

    public aj() {
        e(103006);
    }

    public void a(long j) {
        this.a = j;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryGroupGradeReq.QueryGroupGradeReqIdl.newBuilder().a(QueryGroupGradeReq.DataReq.newBuilder().a((int) this.a).build()).build();
    }
}
