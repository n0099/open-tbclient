package com.baidu.tieba.gift.buyGift;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetGiftCommonList.GetGiftCommonListResIdl;
/* loaded from: classes.dex */
public class GetGiftCommonListHttpResponseMessage extends TbHttpResponsedMessage {
    private GiftCommonList giftCommonList;

    public GetGiftCommonListHttpResponseMessage(int i) {
        super(CmdConfigHttp.GET_GIFT_LIST);
    }

    public GiftCommonList getGiftInfo() {
        return this.giftCommonList;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        this.giftCommonList = new GiftCommonList();
        this.giftCommonList.parseProto((GetGiftCommonListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftCommonListResIdl.class));
    }
}
