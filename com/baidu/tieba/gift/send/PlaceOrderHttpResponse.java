package com.baidu.tieba.gift.send;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.PlaceOrder.PlaceOrderResIdl;
/* loaded from: classes8.dex */
public class PlaceOrderHttpResponse extends TbHttpResponsedMessage {
    private a orderInfo;

    public PlaceOrderHttpResponse(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
