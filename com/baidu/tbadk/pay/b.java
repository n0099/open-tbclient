package com.baidu.tbadk.pay;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.i;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private a awj;
    private final com.baidu.adp.framework.listener.a awk;

    public b(BaseActivity<?> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.awk = new c(this, CmdConfigHttp.CMD_GET_PAY_CONFIG, 303039);
        this.awj = aVar;
        registerListener(this.awk);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void DC() {
        if (!e.DD().DE()) {
            if (this.awj != null) {
                this.awj.DA();
                return;
            }
            return;
        }
        PayConfigNetMessage payConfigNetMessage = new PayConfigNetMessage();
        payConfigNetMessage.setType("payType");
        sendMessage(payConfigNetMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        if (dataRes == null || dataRes.payType == null) {
            if (this.awj != null) {
                this.awj.onError(TbadkCoreApplication.m411getInst().getString(i.C0057i.data_load_error));
            }
        } else if (dataRes.payType.pay_type.intValue() == 1) {
            if (this.awj != null) {
                this.awj.DB();
            }
        } else if (dataRes.payType.pay_type.intValue() == 2) {
            if (this.awj != null) {
                this.awj.DA();
            }
        } else if (this.awj != null) {
            this.awj.onError("");
        }
    }
}
