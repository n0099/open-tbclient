package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.a0.a;
import d.b.i0.a0.b;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetUserOrder.DataRes;
import tbclient.GetUserOrder.GetUserOrderResIdl;
import tbclient.OrderList;
/* loaded from: classes4.dex */
public class GetUserOrderSocketResponseMessage extends SocketResponsedMessage {
    public boolean hasMore;
    public ArrayList<a> orderList;
    public b recommendData;

    public GetUserOrderSocketResponseMessage() {
        super(309271);
        this.hasMore = false;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<a> getOrderList() {
        return this.orderList;
    }

    public b getRecommendInfo() {
        return this.recommendData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetUserOrderResIdl getUserOrderResIdl = (GetUserOrderResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserOrderResIdl.class);
        if (getUserOrderResIdl == null) {
            return;
        }
        Error error = getUserOrderResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getUserOrderResIdl.error.usermsg);
        }
        DataRes dataRes = getUserOrderResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.hasMore = dataRes.hasmore.intValue() == 1;
        List<OrderList> list = getUserOrderResIdl.data.order_list;
        if (list != null && list.size() > 0) {
            this.orderList = new ArrayList<>();
            for (OrderList orderList : getUserOrderResIdl.data.order_list) {
                if (orderList != null) {
                    a aVar = new a();
                    aVar.m(orderList);
                    this.orderList.add(aVar);
                }
            }
        }
        if (getUserOrderResIdl.data.default_info != null) {
            b bVar = new b();
            this.recommendData = bVar;
            bVar.c(getUserOrderResIdl.data.default_info);
        }
    }
}
