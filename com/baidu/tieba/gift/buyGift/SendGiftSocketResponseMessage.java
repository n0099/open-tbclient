package com.baidu.tieba.gift.buyGift;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SendGiftAndroid.SendGiftAndroidResIdl;
/* loaded from: classes.dex */
public class SendGiftSocketResponseMessage extends SocketResponsedMessage {
    private SendGiftAndroidResIdl mResponseData;

    public SendGiftSocketResponseMessage() {
        super(308007);
    }

    public SendGiftAndroidResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        this.mResponseData = (SendGiftAndroidResIdl) new Wire(new Class[0]).parseFrom(bArr, SendGiftAndroidResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
