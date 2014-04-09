package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import protobuf.LogStat.LogStatRes;
/* loaded from: classes.dex */
public class ResponseSendPVTJMessage extends TbSocketReponsedMessage {
    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        LogStatRes.LogStatResIdl parseFrom = LogStatRes.LogStatResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
    }

    public ResponseSendPVTJMessage() {
        super(104001);
    }
}
