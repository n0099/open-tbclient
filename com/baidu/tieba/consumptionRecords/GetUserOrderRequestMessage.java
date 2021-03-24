package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.GetUserOrder.DataReq;
import tbclient.GetUserOrder.GetUserOrderReqIdl;
/* loaded from: classes4.dex */
public class GetUserOrderRequestMessage extends NetMessage {
    public int orderType;
    public int pn;
    public int rn;
    public int showMember;

    public GetUserOrderRequestMessage() {
        super(CmdConfigHttp.CMD_GET_USER_ORDER, 309271);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.order_type = Integer.valueOf(this.orderType);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.show_member = Integer.valueOf(this.showMember);
        if (z) {
            w.a(builder, true);
        }
        GetUserOrderReqIdl.Builder builder2 = new GetUserOrderReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getOrderType() {
        return this.orderType;
    }

    public int getPn() {
        return this.pn;
    }

    public int getRn() {
        return this.rn;
    }

    public int getShowMember() {
        return this.showMember;
    }

    public void setOrderType(int i) {
        this.orderType = i;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public void setShowMember(int i) {
        this.showMember = i;
    }
}
