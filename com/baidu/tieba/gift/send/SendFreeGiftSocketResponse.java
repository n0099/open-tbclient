package com.baidu.tieba.gift.send;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SendFreeGift.DataRes;
import tbclient.SendFreeGift.SendFreeGiftResIdl;
/* loaded from: classes4.dex */
public class SendFreeGiftSocketResponse extends TbSocketReponsedMessage {
    public int freeChance;

    public SendFreeGiftSocketResponse() {
        super(309050);
    }

    public int getFreeChance() {
        return this.freeChance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        SendFreeGiftResIdl sendFreeGiftResIdl = (SendFreeGiftResIdl) new Wire(new Class[0]).parseFrom(bArr, SendFreeGiftResIdl.class);
        if (sendFreeGiftResIdl == null) {
            return;
        }
        Error error = sendFreeGiftResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(sendFreeGiftResIdl.error.usermsg);
        }
        DataRes dataRes = sendFreeGiftResIdl.data;
        if (dataRes != null) {
            this.freeChance = dataRes.free_chance.intValue();
        }
    }
}
