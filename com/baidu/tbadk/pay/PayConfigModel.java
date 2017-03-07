package com.baidu.tbadk.pay;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.clientConfig.ClientConfigNetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.w;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class PayConfigModel extends BdBaseModel {
    private a aFi;
    private final com.baidu.adp.framework.listener.a aFj;

    public PayConfigModel(BaseActivity<?> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.aFj = new b(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.aFi = aVar;
        registerListener(this.aFj);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void FI() {
        if (!d.FJ().FK()) {
            if (this.aFi != null) {
                this.aFi.FG();
                return;
            }
            return;
        }
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType("payType");
        sendMessage(clientConfigNetMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        if (dataRes == null || dataRes.payType == null) {
            if (this.aFi != null) {
                this.aFi.onError(TbadkCoreApplication.m9getInst().getString(w.l.data_load_error));
            }
        } else if (dataRes.payType.pay_type.intValue() == 1) {
            if (this.aFi != null) {
                this.aFi.FH();
            }
        } else if (dataRes.payType.pay_type.intValue() == 2) {
            if (this.aFi != null) {
                this.aFi.FG();
            }
        } else if (this.aFi != null) {
            this.aFi.onError("");
        }
    }
}
