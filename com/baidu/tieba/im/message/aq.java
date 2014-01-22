package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.QueryPrize.QueryPrizeReq;
/* loaded from: classes.dex */
public class aq extends q implements com.baidu.tieba.im.coder.g {
    private int a;

    public aq() {
        e(103013);
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        try {
            return QueryPrizeReq.QueryPrizeReqIdl.newBuilder().a(QueryPrizeReq.DataReq.newBuilder().a(this.a).build()).build();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.d("data convert error");
            return null;
        }
    }
}
