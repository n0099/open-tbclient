package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.QueryPrize.QueryPrizeRes;
/* loaded from: classes.dex */
public class ResponseQueryPrizeMessage extends SocketResponsedMessage {
    private int a;
    private String b;
    private QueryPrizeRes.PrizeInfo c;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        QueryPrizeRes.QueryPrizeResIdl parseFrom = QueryPrizeRes.QueryPrizeResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = parseFrom.getData().getMsgInOneDay();
            this.b = parseFrom.getData().getNoSendMsgTip();
            this.c = parseFrom.getData().getPrize();
        }
    }

    public ResponseQueryPrizeMessage() {
        super(103013);
    }

    public final int d() {
        return this.a;
    }

    public final String i() {
        return this.b;
    }

    public final QueryPrizeRes.PrizeInfo j() {
        return this.c;
    }
}
