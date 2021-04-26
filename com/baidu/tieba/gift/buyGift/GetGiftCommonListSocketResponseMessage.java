package com.baidu.tieba.gift.buyGift;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetGiftCommonList.GetGiftCommonListResIdl;
@Deprecated
/* loaded from: classes4.dex */
public class GetGiftCommonListSocketResponseMessage extends SocketResponsedMessage {
    public GiftCommonList giftCommonList;

    public GetGiftCommonListSocketResponseMessage() {
        super(308001);
    }

    public GiftCommonList getGiftInfo() {
        return this.giftCommonList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GiftCommonList giftCommonList = new GiftCommonList();
        this.giftCommonList = giftCommonList;
        giftCommonList.parseProto((GetGiftCommonListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftCommonListResIdl.class));
    }
}
