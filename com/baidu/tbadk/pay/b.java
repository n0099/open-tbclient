package com.baidu.tbadk.pay;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.clientConfig.ClientConfigNetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.r;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private a aBE;
    private final com.baidu.adp.framework.listener.a aBF;

    public b(BaseActivity<?> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.aBF = new c(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.aBE = aVar;
        registerListener(this.aBF);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void FU() {
        if (!e.FV().FW()) {
            if (this.aBE != null) {
                this.aBE.FS();
                return;
            }
            return;
        }
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType("payType");
        sendMessage(clientConfigNetMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aBF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        if (dataRes == null || dataRes.payType == null) {
            if (this.aBE != null) {
                this.aBE.onError(TbadkCoreApplication.m9getInst().getString(r.j.data_load_error));
            }
        } else if (dataRes.payType.pay_type.intValue() == 1) {
            if (this.aBE != null) {
                this.aBE.FT();
            }
        } else if (dataRes.payType.pay_type.intValue() == 2) {
            if (this.aBE != null) {
                this.aBE.FS();
            }
        } else if (this.aBE != null) {
            this.aBE.onError("");
        }
    }
}
