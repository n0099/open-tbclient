package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupActivity.QueryGroupActivityReq;
/* loaded from: classes.dex */
public final class am extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private int b;

    public am() {
        e(103015);
    }

    public final void a(int i) {
        this.b = i;
    }

    public final int b() {
        return this.a;
    }

    public final void b(int i) {
        this.a = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return QueryGroupActivityReq.QueryGroupActivityReqIdl.newBuilder().a(QueryGroupActivityReq.DataReq.newBuilder().a(this.a).b(this.b).build()).build();
    }
}
