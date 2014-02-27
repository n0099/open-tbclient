package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupLocation.QueryGroupLocationReq;
/* loaded from: classes.dex */
public final class av extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private String b;
    private String c;

    public av() {
        e(103010);
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return QueryGroupLocationReq.QueryGroupLocationReqIdl.newBuilder().a(QueryGroupLocationReq.DataReq.newBuilder().a(this.a).b(Double.parseDouble(this.c)).a(Double.parseDouble(this.b)).build()).build();
    }
}
