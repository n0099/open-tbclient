package com.baidu.tieba.im.message;

import java.util.LinkedList;
import protobuf.QueryPrize.QueryPrizeRes;
/* loaded from: classes.dex */
public class cd extends cr implements com.baidu.tieba.im.coder.f {
    private int a;
    private String b;
    private QueryPrizeRes.PrizeInfo c;

    public cd() {
        e(103013);
    }

    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<q> linkedList, byte[] bArr, int i) {
        QueryPrizeRes.QueryPrizeResIdl parseFrom = QueryPrizeRes.QueryPrizeResIdl.parseFrom(bArr);
        g(parseFrom.getError().getErrorno());
        c(parseFrom.getError().getUsermsg());
        linkedList.add(this);
        if (!k()) {
            this.a = parseFrom.getData().getMsgInOneDay();
            this.b = parseFrom.getData().getNoSendMsgTip();
            this.c = parseFrom.getData().getPrize();
        }
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public QueryPrizeRes.PrizeInfo c() {
        return this.c;
    }
}
