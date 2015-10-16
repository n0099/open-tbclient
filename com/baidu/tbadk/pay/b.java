package com.baidu.tbadk.pay;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.clientConfig.ClientConfigNetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.i;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private a awr;
    private final com.baidu.adp.framework.listener.a aws;

    public b(BaseActivity<?> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.aws = new c(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.awr = aVar;
        registerListener(this.aws);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void Dz() {
        if (!e.DA().DB()) {
            if (this.awr != null) {
                this.awr.Dx();
                return;
            }
            return;
        }
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType("payType");
        sendMessage(clientConfigNetMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        if (dataRes == null || dataRes.payType == null) {
            if (this.awr != null) {
                this.awr.onError(TbadkCoreApplication.m411getInst().getString(i.h.data_load_error));
            }
        } else if (dataRes.payType.pay_type.intValue() == 1) {
            if (this.awr != null) {
                this.awr.Dy();
            }
        } else if (dataRes.payType.pay_type.intValue() == 2) {
            if (this.awr != null) {
                this.awr.Dx();
            }
        } else if (this.awr != null) {
            this.awr.onError("");
        }
    }
}
