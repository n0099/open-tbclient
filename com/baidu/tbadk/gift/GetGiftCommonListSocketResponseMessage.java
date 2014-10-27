package com.baidu.tbadk.gift;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetGiftCommonList.GetGiftCommonListResIdl;
/* loaded from: classes.dex */
public class GetGiftCommonListSocketResponseMessage extends SocketResponsedMessage {
    private GiftCommonList giftCommonList;

    public GetGiftCommonListSocketResponseMessage() {
        super(308001);
    }

    public GiftCommonList getGiftInfo() {
        return this.giftCommonList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        this.giftCommonList = new GiftCommonList();
        this.giftCommonList.parseProto((GetGiftCommonListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftCommonListResIdl.class));
    }
}
