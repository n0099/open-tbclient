package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupLocation.QueryGroupLocationReq;
/* loaded from: classes.dex */
public class ai extends n implements com.baidu.tieba.im.coder.g {
    private int a;
    private String b;
    private String c;

    public ai() {
        e(103010);
    }

    public int b() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public String c() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String d() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return QueryGroupLocationReq.QueryGroupLocationReqIdl.newBuilder().a(QueryGroupLocationReq.DataReq.newBuilder().a(b()).b(Double.parseDouble(d())).a(Double.parseDouble(c())).build()).build();
    }
}
