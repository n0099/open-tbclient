package com.baidu.tieba.gift.send;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SendFreeGift.SendFreeGiftResIdl;
/* loaded from: classes8.dex */
public class SendFreeGiftHttpResponse extends TbHttpResponsedMessage {
    private int freeChance;

    public SendFreeGiftHttpResponse(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SendFreeGiftResIdl sendFreeGiftResIdl = (SendFreeGiftResIdl) new Wire(new Class[0]).parseFrom(bArr, SendFreeGiftResIdl.class);
        if (sendFreeGiftResIdl != null) {
            if (sendFreeGiftResIdl.error != null) {
                setError(sendFreeGiftResIdl.error.errorno.intValue());
                setErrorString(sendFreeGiftResIdl.error.usermsg);
            }
            if (sendFreeGiftResIdl.data != null) {
                this.freeChance = sendFreeGiftResIdl.data.free_chance.intValue();
            }
        }
    }

    public int getFreeChance() {
        return this.freeChance;
    }
}
