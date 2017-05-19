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
    private a aFE;
    private final com.baidu.adp.framework.listener.a aFF;

    public PayConfigModel(BaseActivity<?> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.aFF = new b(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.aFE = aVar;
        registerListener(this.aFF);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void Fk() {
        if (!d.Fl().Fm()) {
            if (this.aFE != null) {
                this.aFE.Fi();
                return;
            }
            return;
        }
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType("payType");
        sendMessage(clientConfigNetMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aFF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        if (dataRes == null || dataRes.payType == null) {
            if (this.aFE != null) {
                this.aFE.onError(TbadkCoreApplication.m9getInst().getString(w.l.data_load_error));
            }
        } else if (dataRes.payType.pay_type.intValue() == 1) {
            if (this.aFE != null) {
                this.aFE.Fj();
            }
        } else if (dataRes.payType.pay_type.intValue() == 2) {
            if (this.aFE != null) {
                this.aFE.Fi();
            }
        } else if (this.aFE != null) {
            this.aFE.onError("");
        }
    }
}
