package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.CommitPusherCount.CommitPusherCountRes;
/* loaded from: classes.dex */
public class ResponsePushCountMessage extends SocketResponsedMessage {
    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        CommitPusherCountRes.CommitPusherCountResIdl parseFrom = CommitPusherCountRes.CommitPusherCountResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() != 0) {
        }
    }

    public ResponsePushCountMessage() {
        super(202101);
    }
}
