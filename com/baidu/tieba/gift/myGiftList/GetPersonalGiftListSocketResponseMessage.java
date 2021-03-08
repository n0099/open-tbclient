package com.baidu.tieba.gift.myGiftList;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetMyGift.GetMyGiftResIdl;
/* loaded from: classes8.dex */
public class GetPersonalGiftListSocketResponseMessage extends TbSocketReponsedMessage {
    private a giftListData;

    public GetPersonalGiftListSocketResponseMessage() {
        super(CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
