package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetUserOrder.DataReq;
import tbclient.GetUserOrder.GetUserOrderReqIdl;
/* loaded from: classes8.dex */
public class GetUserOrderRequestMessage extends NetMessage {
    private int orderType;
    private int pn;
    private int rn;
    private int showMember;

    public GetUserOrderRequestMessage() {
        super(1003075, CmdConfigSocket.CMD_GET_USER_ORDER);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.order_type = Integer.valueOf(this.orderType);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.show_member = Integer.valueOf(this.showMember);
        if (z) {
            t.b(builder, true);
        }
        GetUserOrderReqIdl.Builder builder2 = new GetUserOrderReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getPn() {
        return this.pn;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public void setOrderType(int i) {
        this.orderType = i;
    }

    public int getShowMember() {
        return this.showMember;
    }

    public void setShowMember(int i) {
        this.showMember = i;
    }
}
