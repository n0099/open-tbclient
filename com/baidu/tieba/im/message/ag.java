package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryHotGroups.QueryHotGroupsReq;
/* loaded from: classes.dex */
public class ag extends o implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;
    private int c;
    private int d;

    public ag(int i, int i2, int i3, int i4) {
        super.e(103012);
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.d;
    }

    public boolean f() {
        return this.d == 0;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryHotGroupsReq.QueryHotGroupsReqIdl.newBuilder().a(QueryHotGroupsReq.DataReq.newBuilder().c(d()).a(e()).b(b()).d(c()).build()).build();
    }
}
