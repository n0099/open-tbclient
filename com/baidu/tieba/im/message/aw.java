package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryPrize.QueryPrizeReq;
/* loaded from: classes.dex */
public final class aw extends s implements com.baidu.tieba.im.coder.g {
    private int a;

    public aw() {
        e(103013);
    }

    public final void a(int i) {
        this.a = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        try {
            return QueryPrizeReq.QueryPrizeReqIdl.newBuilder().a(QueryPrizeReq.DataReq.newBuilder().a(this.a).build()).build();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.e("data convert error");
            return null;
        }
    }
}
