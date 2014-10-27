package com.baidu.tbadk.gift;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SendGift.SendGiftResIdl;
/* loaded from: classes.dex */
public class SendGiftHttpResponseMessage extends TbHttpResponsedMessage {
    private SendGiftResIdl mResponseData;

    public SendGiftHttpResponseMessage(int i) {
        super(CmdConfigHttp.SEND_GIFT);
    }

    public SendGiftResIdl getResponseData() {
        return this.mResponseData;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        super.decodeInBackGround(i, bArr);
        this.mResponseData = (SendGiftResIdl) new Wire(new Class[0]).parseFrom(bArr, SendGiftResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
