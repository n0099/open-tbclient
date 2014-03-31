package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupLocation.QueryGroupLocationReq;
/* loaded from: classes.dex */
public final class as extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private String b;
    private String c;

    public as() {
        super(103010);
    }

    public final void d(int i) {
        this.a = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return QueryGroupLocationReq.QueryGroupLocationReqIdl.newBuilder().a(QueryGroupLocationReq.DataReq.newBuilder().a(this.a).b(Double.parseDouble(this.c)).a(Double.parseDouble(this.b)).build()).build();
    }
}
