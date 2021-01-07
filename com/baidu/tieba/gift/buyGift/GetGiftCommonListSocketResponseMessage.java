package com.baidu.tieba.gift.buyGift;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.GetGiftCommonList.GetGiftCommonListResIdl;
/* loaded from: classes9.dex */
public class GetGiftCommonListSocketResponseMessage extends SocketResponsedMessage {
    private GiftCommonList giftCommonList;

    public GetGiftCommonListSocketResponseMessage() {
        super(CmdConfigSocket.CMD_GET_GIFT_LIST);
    }

    public GiftCommonList getGiftInfo() {
        return this.giftCommonList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.giftCommonList = new GiftCommonList();
        this.giftCommonList.parseProto((GetGiftCommonListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftCommonListResIdl.class));
    }
}
