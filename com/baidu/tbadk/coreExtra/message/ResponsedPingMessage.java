package com.baidu.tbadk.coreExtra.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
/* loaded from: classes.dex */
public class ResponsedPingMessage extends TbSocketReponsedMessage {
    public ResponsedPingMessage() {
        super(MessageTypes.CMD_PING);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
    }
}
