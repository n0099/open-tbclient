package com.baidu.tieba.gift.buyGift;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetGiftCommonList.GetGiftCommonListResIdl;
@Deprecated
/* loaded from: classes4.dex */
public class GetGiftCommonListHttpResponseMessage extends TbHttpResponsedMessage {
    public GiftCommonList giftCommonList;

    public GetGiftCommonListHttpResponseMessage(int i2) {
        super(CmdConfigHttp.GET_GIFT_LIST);
    }

    public GiftCommonList getGiftInfo() {
        return this.giftCommonList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GiftCommonList giftCommonList = new GiftCommonList();
        this.giftCommonList = giftCommonList;
        giftCommonList.parseProto((GetGiftCommonListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftCommonListResIdl.class));
    }
}
