package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryHotGroups.QueryHotGroupsReq;
/* loaded from: classes.dex */
public final class aq extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;
    private int c;
    private int d;

    public aq(int i, int i2, int i3, int i4) {
        super.e(103012);
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final boolean b() {
        return this.d == 0;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return QueryHotGroupsReq.QueryHotGroupsReqIdl.newBuilder().a(QueryHotGroupsReq.DataReq.newBuilder().c(this.b).a(this.d).b(this.c).d(this.a).build()).build();
    }
}
