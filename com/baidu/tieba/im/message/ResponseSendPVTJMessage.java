package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.LogStat.LogStatResIdl;
/* loaded from: classes3.dex */
public class ResponseSendPVTJMessage extends TbSocketReponsedMessage {
    public ResponseSendPVTJMessage() {
        super(104001);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        LogStatResIdl logStatResIdl = (LogStatResIdl) new Wire(new Class[0]).parseFrom(bArr, LogStatResIdl.class);
        setError(logStatResIdl.error.errorno.intValue());
        setErrorString(logStatResIdl.error.usermsg);
    }
}
