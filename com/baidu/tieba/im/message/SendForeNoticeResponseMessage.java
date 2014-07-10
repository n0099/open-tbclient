package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import protobuf.SendForenoticeMsg.SendForenoticeMsgResIdl;
/* loaded from: classes.dex */
public class SendForeNoticeResponseMessage extends TbSocketReponsedMessage {
    private String userMsg;

    public SendForeNoticeResponseMessage() {
        super(107107);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        SendForenoticeMsgResIdl sendForenoticeMsgResIdl = (SendForenoticeMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, SendForenoticeMsgResIdl.class);
        setError(sendForenoticeMsgResIdl.error.errorno.intValue());
        setErrorString(sendForenoticeMsgResIdl.error.usermsg);
        this.userMsg = sendForenoticeMsgResIdl.error.usermsg;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        return (getError() == 0 || getError() == 2360012) ? false : true;
    }

    public String getUserMsg() {
        return this.userMsg;
    }
}
