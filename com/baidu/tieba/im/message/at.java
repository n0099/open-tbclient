package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryPrize.QueryPrizeReq;
/* loaded from: classes.dex */
public final class at extends com.baidu.tbadk.message.websockt.d {
    private int a;

    public at() {
        super(103013);
    }

    public final void d(int i) {
        this.a = i;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        try {
            return QueryPrizeReq.QueryPrizeReqIdl.newBuilder().a(QueryPrizeReq.DataReq.newBuilder().a(this.a).build()).build();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.e("data convert error");
            return null;
        }
    }
}
