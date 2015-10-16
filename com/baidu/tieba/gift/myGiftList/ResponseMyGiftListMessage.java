package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetGiftMyList.DataRes;
import tbclient.GetGiftMyList.GetGiftMyListResIdl;
/* loaded from: classes.dex */
public class ResponseMyGiftListMessage extends TbSocketReponsedMessage {
    private DataRes mGiftPageInfo;

    public ResponseMyGiftListMessage() {
        super(308002);
    }

    public DataRes getGiftPageInfo() {
        return this.mGiftPageInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetGiftMyListResIdl getGiftMyListResIdl = (GetGiftMyListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetGiftMyListResIdl.class);
        setError(getGiftMyListResIdl.error.errorno.intValue());
        setErrorString(getGiftMyListResIdl.error.usermsg);
        if (getError() == 0) {
            this.mGiftPageInfo = getGiftMyListResIdl.data;
        }
    }
}
