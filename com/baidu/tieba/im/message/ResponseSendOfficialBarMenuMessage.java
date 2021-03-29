package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.SendMenuMsg.SendMenuMsgResIdl;
/* loaded from: classes3.dex */
public class ResponseSendOfficialBarMenuMessage extends SocketResponsedMessage {
    public ResponseSendOfficialBarMenuMessage() {
        super(208003);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SendMenuMsgResIdl sendMenuMsgResIdl = (SendMenuMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, SendMenuMsgResIdl.class);
        setError(sendMenuMsgResIdl.error.errorno.intValue());
        setErrorString(sendMenuMsgResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
