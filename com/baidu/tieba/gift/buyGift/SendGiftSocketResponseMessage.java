package com.baidu.tieba.gift.buyGift;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SendGiftAndroid.SendGiftAndroidResIdl;
/* loaded from: classes4.dex */
public class SendGiftSocketResponseMessage extends SocketResponsedMessage {
    public SendGiftAndroidResIdl mResponseData;

    public SendGiftSocketResponseMessage() {
        super(308007);
    }

    public SendGiftAndroidResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SendGiftAndroidResIdl sendGiftAndroidResIdl = (SendGiftAndroidResIdl) new Wire(new Class[0]).parseFrom(bArr, SendGiftAndroidResIdl.class);
        this.mResponseData = sendGiftAndroidResIdl;
        Error error = sendGiftAndroidResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
