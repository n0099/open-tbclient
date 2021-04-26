package com.baidu.tbadk.coreExtra.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
/* loaded from: classes3.dex */
public class ResponsedPingMessage extends TbSocketReponsedMessage {
    public ResponsedPingMessage() {
        super(1003);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
    }
}
