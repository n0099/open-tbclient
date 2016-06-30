package com.baidu.tbadk.pay;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.clientConfig.ClientConfigNetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.u;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private a axn;
    private final com.baidu.adp.framework.listener.a axo;

    public b(BaseActivity<?> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.axo = new c(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.axn = aVar;
        registerListener(this.axo);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void Ey() {
        if (!e.Ez().EA()) {
            if (this.axn != null) {
                this.axn.Ew();
                return;
            }
            return;
        }
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType("payType");
        sendMessage(clientConfigNetMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.axo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        if (dataRes == null || dataRes.payType == null) {
            if (this.axn != null) {
                this.axn.onError(TbadkCoreApplication.m9getInst().getString(u.j.data_load_error));
            }
        } else if (dataRes.payType.pay_type.intValue() == 1) {
            if (this.axn != null) {
                this.axn.Ex();
            }
        } else if (dataRes.payType.pay_type.intValue() == 2) {
            if (this.axn != null) {
                this.axn.Ew();
            }
        } else if (this.axn != null) {
            this.axn.onError("");
        }
    }
}
