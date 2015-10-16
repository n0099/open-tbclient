package com.baidu.tieba.gift.buyGift;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SendGiftAndroid.SendGiftAndroidResIdl;
/* loaded from: classes.dex */
public class SendGiftHttpResponseMessage extends TbHttpResponsedMessage {
    private SendGiftAndroidResIdl mResponseData;

    public SendGiftHttpResponseMessage(int i) {
        super(CmdConfigHttp.SEND_GIFT);
    }

    public SendGiftAndroidResIdl getResponseData() {
        return this.mResponseData;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        super.decodeInBackGround(i, bArr);
        this.mResponseData = (SendGiftAndroidResIdl) new Wire(new Class[0]).parseFrom(bArr, SendGiftAndroidResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
