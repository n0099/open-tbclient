package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.GetUserOrder.GetUserOrderResIdl;
import tbclient.OrderList;
/* loaded from: classes9.dex */
public class GetUserOrderSocketResponseMessage extends SocketResponsedMessage {
    private boolean hasMore;
    private ArrayList<a> orderList;
    private b recommendData;

    public GetUserOrderSocketResponseMessage() {
        super(CmdConfigSocket.CMD_GET_USER_ORDER);
        this.hasMore = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetUserOrderResIdl getUserOrderResIdl = (GetUserOrderResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserOrderResIdl.class);
        if (getUserOrderResIdl != null) {
            if (getUserOrderResIdl.error != null) {
                setError(getUserOrderResIdl.error.errorno.intValue());
                setErrorString(getUserOrderResIdl.error.usermsg);
            }
            if (getUserOrderResIdl.data != null) {
                this.hasMore = getUserOrderResIdl.data.hasmore.intValue() == 1;
                if (getUserOrderResIdl.data.order_list != null && getUserOrderResIdl.data.order_list.size() > 0) {
                    this.orderList = new ArrayList<>();
                    for (OrderList orderList : getUserOrderResIdl.data.order_list) {
                        if (orderList != null) {
                            a aVar = new a();
                            aVar.a(orderList);
                            this.orderList.add(aVar);
                        }
                    }
                }
                if (getUserOrderResIdl.data.default_info != null) {
                    this.recommendData = new b();
                    this.recommendData.a(getUserOrderResIdl.data.default_info);
                }
            }
        }
    }

    public ArrayList<a> getOrderList() {
        return this.orderList;
    }

    public b getRecommendInfo() {
        return this.recommendData;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }
}
