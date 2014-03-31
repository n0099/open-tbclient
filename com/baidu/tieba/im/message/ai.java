package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryGroupActivity.QueryGroupActivityReq;
/* loaded from: classes.dex */
public final class ai extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private int b;

    public ai() {
        super(103015);
    }

    public final void d(int i) {
        this.b = i;
    }

    public final void e(int i) {
        this.a = i;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return QueryGroupActivityReq.QueryGroupActivityReqIdl.newBuilder().a(QueryGroupActivityReq.DataReq.newBuilder().a(this.a).b(this.b).build()).build();
    }
}
