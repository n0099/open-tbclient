package com.baidu.tbadk.coreExtra.message;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
/* loaded from: classes2.dex */
public class ResponsedPingMessage extends TbSocketReponsedMessage {
    public ResponsedPingMessage() {
        super(1003);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
    }
}
