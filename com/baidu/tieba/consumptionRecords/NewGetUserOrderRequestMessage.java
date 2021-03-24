package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.wallet.api.Constants;
/* loaded from: classes4.dex */
public class NewGetUserOrderRequestMessage extends HttpMessage {
    public int orderType;
    public int pn;
    public int rn;
    public int showMember;

    public NewGetUserOrderRequestMessage() {
        super(CmdConfigHttp.CMD_GET_USER_ORDER);
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
        addParam(Constants.ORDERTYPE_FLAG, i);
    }

    public void setPn(int i) {
        this.pn = i;
        addParam(Config.PACKAGE_NAME, i);
    }

    public void setRn(int i) {
        this.rn = i;
        addParam("rn", i);
    }

    public void setShowMember(int i) {
        this.showMember = i;
        addParam("show_member", i);
    }
}
