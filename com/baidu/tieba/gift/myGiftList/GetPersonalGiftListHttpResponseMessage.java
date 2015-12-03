package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetMyGift.GetMyGiftResIdl;
/* loaded from: classes.dex */
public class GetPersonalGiftListHttpResponseMessage extends TbHttpResponsedMessage {
    private a giftListData;

    public GetPersonalGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        GetMyGiftResIdl getMyGiftResIdl = (GetMyGiftResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMyGiftResIdl.class);
        if (getMyGiftResIdl != null) {
            if (getMyGiftResIdl.error != null) {
                setError(getMyGiftResIdl.error.errorno.intValue());
                setErrorString(getMyGiftResIdl.error.usermsg);
            }
            this.giftListData = new a();
            this.giftListData.a(getMyGiftResIdl.data);
        }
    }

    public a getGiftListData() {
        return this.giftListData;
    }

    public void setGiftListData(a aVar) {
        this.giftListData = aVar;
    }
}
