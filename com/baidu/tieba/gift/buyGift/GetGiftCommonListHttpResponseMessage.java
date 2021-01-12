package com.baidu.tieba.gift.buyGift;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetGiftCommonList.GetGiftCommonListResIdl;
/* loaded from: classes8.dex */
public class GetGiftCommonListHttpResponseMessage extends TbHttpResponsedMessage {
    private GiftCommonList giftCommonList;

    public GetGiftCommonListHttpResponseMessage(int i) {
        super(1001509);
    }

    public GiftCommonList getGiftInfo() {
        return this.giftCommonList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.giftCommonList = new GiftCommonList();
        this.giftCommonList.parseProto((GetGiftCommonListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftCommonListResIdl.class));
    }
}
