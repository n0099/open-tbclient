package com.baidu.tieba.gift.send;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.PlaceOrder.PlaceOrderResIdl;
/* loaded from: classes.dex */
public class PlaceOrderSocketResponse extends TbSocketReponsedMessage {
    private a orderInfo;

    public PlaceOrderSocketResponse() {
        super(309051);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        PlaceOrderResIdl placeOrderResIdl = (PlaceOrderResIdl) new Wire(new Class[0]).parseFrom(bArr, PlaceOrderResIdl.class);
        if (placeOrderResIdl != null) {
            if (placeOrderResIdl.error != null) {
                setError(placeOrderResIdl.error.errorno.intValue());
                setErrorString(placeOrderResIdl.error.usermsg);
            }
            if (placeOrderResIdl.data != null) {
                this.orderInfo = new a();
                this.orderInfo.a(placeOrderResIdl.data);
            }
        }
    }

    public a getOrderInfo() {
        return this.orderInfo;
    }
}
