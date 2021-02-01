package com.baidu.tieba.gift.buyGift;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SendGiftAndroid.SendGiftAndroidResIdl;
/* loaded from: classes9.dex */
public class SendGiftHttpResponseMessage extends TbHttpResponsedMessage {
    private SendGiftAndroidResIdl mResponseData;

    public SendGiftHttpResponseMessage(int i) {
        super(1001510);
    }

    public SendGiftAndroidResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        this.mResponseData = (SendGiftAndroidResIdl) new Wire(new Class[0]).parseFrom(bArr, SendGiftAndroidResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
