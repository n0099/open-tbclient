package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.k0.u0.c.a;
import tbclient.Error;
import tbclient.GetMyGift.GetMyGiftResIdl;
/* loaded from: classes4.dex */
public class GetPersonalGiftListHttpResponseMessage extends TbHttpResponsedMessage {
    public a giftListData;

    public GetPersonalGiftListHttpResponseMessage(int i2) {
        super(i2);
    }

    public a getGiftListData() {
        return this.giftListData;
    }

    public void setGiftListData(a aVar) {
        this.giftListData = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetMyGiftResIdl getMyGiftResIdl = (GetMyGiftResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMyGiftResIdl.class);
        if (getMyGiftResIdl == null) {
            return;
        }
        Error error = getMyGiftResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getMyGiftResIdl.error.usermsg);
        }
        a aVar = new a();
        this.giftListData = aVar;
        aVar.f(getMyGiftResIdl.data);
    }
}
