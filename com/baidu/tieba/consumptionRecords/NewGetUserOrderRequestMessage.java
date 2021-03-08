package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.mobstat.Config;
/* loaded from: classes8.dex */
public class NewGetUserOrderRequestMessage extends HttpMessage {
    private int orderType;
    private int pn;
    private int rn;
    private int showMember;

    public NewGetUserOrderRequestMessage() {
        super(1003075);
    }

    public int getPn() {
        return this.pn;
    }

    public void setPn(int i) {
        this.pn = i;
        addParam(Config.PACKAGE_NAME, i);
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
        addParam("rn", i);
    }

    public int getOrderType() {
        return this.orderType;
    }

    public void setOrderType(int i) {
        this.orderType = i;
        addParam("order_type", i);
    }

    public int getShowMember() {
        return this.showMember;
    }

    public void setShowMember(int i) {
        this.showMember = i;
        addParam("show_member", i);
    }
}
