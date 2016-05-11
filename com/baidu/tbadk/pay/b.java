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
    private a awx;
    private final com.baidu.adp.framework.listener.a awy;

    public b(BaseActivity<?> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.awy = new c(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.awx = aVar;
        registerListener(this.awy);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void Eo() {
        if (!e.Ep().Eq()) {
            if (this.awx != null) {
                this.awx.Em();
                return;
            }
            return;
        }
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType("payType");
        sendMessage(clientConfigNetMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.awy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        if (dataRes == null || dataRes.payType == null) {
            if (this.awx != null) {
                this.awx.onError(TbadkCoreApplication.m11getInst().getString(t.j.data_load_error));
            }
        } else if (dataRes.payType.pay_type.intValue() == 1) {
            if (this.awx != null) {
                this.awx.En();
            }
        } else if (dataRes.payType.pay_type.intValue() == 2) {
            if (this.awx != null) {
                this.awx.Em();
            }
        } else if (this.awx != null) {
            this.awx.onError("");
        }
    }
}
