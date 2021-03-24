package com.baidu.tieba.gift.buyGift;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SendGiftAndroid.SendGiftAndroidResIdl;
/* loaded from: classes4.dex */
public class SendGiftHttpResponseMessage extends TbHttpResponsedMessage {
    public SendGiftAndroidResIdl mResponseData;

    public SendGiftHttpResponseMessage(int i) {
        super(CmdConfigHttp.SEND_GIFT);
    }

    public SendGiftAndroidResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        SendGiftAndroidResIdl sendGiftAndroidResIdl = (SendGiftAndroidResIdl) new Wire(new Class[0]).parseFrom(bArr, SendGiftAndroidResIdl.class);
        this.mResponseData = sendGiftAndroidResIdl;
        Error error = sendGiftAndroidResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
