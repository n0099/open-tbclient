package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QueryPrize.QueryPrizeRes;
/* loaded from: classes.dex */
public class cm extends da implements com.baidu.tieba.im.coder.f {
    private int a;
    private String b;
    private QueryPrizeRes.PrizeInfo c;

    public cm() {
        e(103013);
    }

    @Override // com.baidu.tieba.im.coder.f
    public final void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        QueryPrizeRes.QueryPrizeResIdl parseFrom = QueryPrizeRes.QueryPrizeResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!l()) {
            this.a = parseFrom.getData().getMsgInOneDay();
            this.b = parseFrom.getData().getNoSendMsgTip();
            this.c = parseFrom.getData().getPrize();
        }
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final QueryPrizeRes.PrizeInfo c() {
        return this.c;
    }
}
