package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.u0.c.a;
import tbclient.Error;
import tbclient.GetMyGift.GetMyGiftResIdl;
/* loaded from: classes4.dex */
public class GetPersonalGiftListSocketResponseMessage extends TbSocketReponsedMessage {
    public a giftListData;

    public GetPersonalGiftListSocketResponseMessage() {
        super(309052);
    }

    public a getGiftListData() {
        return this.giftListData;
    }

    public void setGiftListData(a aVar) {
        this.giftListData = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
