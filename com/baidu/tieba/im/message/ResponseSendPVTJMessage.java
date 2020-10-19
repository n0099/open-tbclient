package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.LogStat.LogStatResIdl;
/* loaded from: classes26.dex */
public class ResponseSendPVTJMessage extends TbSocketReponsedMessage {
    public ResponseSendPVTJMessage() {
        super(CmdConfigSocket.CMD_SEND_PV_TJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        LogStatResIdl logStatResIdl = (LogStatResIdl) new Wire(new Class[0]).parseFrom(bArr, LogStatResIdl.class);
        setError(logStatResIdl.error.errorno.intValue());
        setErrorString(logStatResIdl.error.usermsg);
    }
}
