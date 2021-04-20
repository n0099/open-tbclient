package com.baidu.tieba.gift.send;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.u0.d.a;
import tbclient.Error;
import tbclient.PlaceOrder.PlaceOrderResIdl;
/* loaded from: classes4.dex */
public class PlaceOrderSocketResponse extends TbSocketReponsedMessage {
    public a orderInfo;

    public PlaceOrderSocketResponse() {
        super(309051);
    }

    public a getOrderInfo() {
        return this.orderInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PlaceOrderResIdl placeOrderResIdl = (PlaceOrderResIdl) new Wire(new Class[0]).parseFrom(bArr, PlaceOrderResIdl.class);
        if (placeOrderResIdl == null) {
            return;
        }
        Error error = placeOrderResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(placeOrderResIdl.error.usermsg);
        }
        if (placeOrderResIdl.data != null) {
            a aVar = new a();
            this.orderInfo = aVar;
            aVar.c(placeOrderResIdl.data);
        }
    }
}
