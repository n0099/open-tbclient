package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupCount.QueryGroupCountReq;
/* loaded from: classes.dex */
public final class x extends com.baidu.tbadk.message.websockt.d {
    private String a;
    private String b;

    public x() {
        super(103011);
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void b(String str) {
        this.b = str;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        NumberFormatException e;
        double d;
        double d2 = 0.0d;
        try {
            d = Double.valueOf(this.b).doubleValue();
        } catch (NumberFormatException e2) {
            e = e2;
            d = 0.0d;
        }
        try {
            d2 = Double.valueOf(this.a).doubleValue();
        } catch (NumberFormatException e3) {
            e = e3;
            e.printStackTrace();
            return QueryGroupCountReq.QueryGroupCountReqIdl.newBuilder().a(QueryGroupCountReq.DataReq.newBuilder().b(d).a(d2).build()).build();
        }
        return QueryGroupCountReq.QueryGroupCountReqIdl.newBuilder().a(QueryGroupCountReq.DataReq.newBuilder().b(d).a(d2).build()).build();
    }
}
