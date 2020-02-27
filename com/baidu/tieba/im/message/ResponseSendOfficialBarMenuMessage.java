package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import protobuf.SendMenuMsg.SendMenuMsgResIdl;
/* loaded from: classes13.dex */
public class ResponseSendOfficialBarMenuMessage extends SocketResponsedMessage {
    public ResponseSendOfficialBarMenuMessage() {
        super(CmdConfigSocket.CMD_SEND_OFFICIAL_BAR_MENU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SendMenuMsgResIdl sendMenuMsgResIdl = (SendMenuMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, SendMenuMsgResIdl.class);
        setError(sendMenuMsgResIdl.error.errorno.intValue());
        setErrorString(sendMenuMsgResIdl.error.usermsg);
        if (getError() != 0) {
        }
    }
}
