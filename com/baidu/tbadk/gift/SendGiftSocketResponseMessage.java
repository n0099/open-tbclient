package com.baidu.tbadk.gift;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SendGift.SendGiftResIdl;
/* loaded from: classes.dex */
public class SendGiftSocketResponseMessage extends SocketResponsedMessage {
    private SendGiftResIdl mResponseData;

    public SendGiftSocketResponseMessage() {
        super(308003);
    }

    public SendGiftResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        this.mResponseData = (SendGiftResIdl) new Wire(new Class[0]).parseFrom(bArr, SendGiftResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
