package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetMyGift.GetMyGiftResIdl;
/* loaded from: classes.dex */
public class GetPersonalGiftListSocketResponseMessage extends TbSocketReponsedMessage {
    private a giftListData;

    public GetPersonalGiftListSocketResponseMessage() {
        super(309052);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
