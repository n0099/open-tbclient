package com.baidu.tieba.gift.send;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.SendFreeGift.SendFreeGiftResIdl;
/* loaded from: classes.dex */
public class SendFreeGiftSocketResponse extends TbSocketReponsedMessage {
    private int freeChance;

    public SendFreeGiftSocketResponse() {
        super(309050);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
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
