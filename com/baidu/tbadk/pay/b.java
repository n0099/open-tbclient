package com.baidu.tbadk.pay;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.clientConfig.ClientConfigNetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.t;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private a aBk;
    private final com.baidu.adp.framework.listener.a aBl;

    public b(BaseActivity<?> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.aBl = new c(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.aBk = aVar;
        registerListener(this.aBl);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void FR() {
        if (!e.FS().FT()) {
            if (this.aBk != null) {
                this.aBk.FP();
                return;
            }
            return;
        }
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType("payType");
        sendMessage(clientConfigNetMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aBl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        if (dataRes == null || dataRes.payType == null) {
            if (this.aBk != null) {
                this.aBk.onError(TbadkCoreApplication.m9getInst().getString(t.j.data_load_error));
            }
        } else if (dataRes.payType.pay_type.intValue() == 1) {
            if (this.aBk != null) {
                this.aBk.FQ();
            }
        } else if (dataRes.payType.pay_type.intValue() == 2) {
            if (this.aBk != null) {
                this.aBk.FP();
            }
        } else if (this.aBk != null) {
            this.aBk.onError("");
        }
    }
}
