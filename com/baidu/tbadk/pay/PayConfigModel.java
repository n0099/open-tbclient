package com.baidu.tbadk.pay;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigNetMessage;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.d;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class PayConfigModel extends BdBaseModel {
    private a aII;
    private final com.baidu.adp.framework.listener.a aIJ;

    public PayConfigModel(BaseActivity<?> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.aIJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039) { // from class: com.baidu.tbadk.pay.PayConfigModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (PayConfigModel.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.l.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        if (PayConfigModel.this.aII != null) {
                            PayConfigModel.this.aII.onError(string);
                        }
                    } else if (responsedMessage instanceof ClientConfigHttpProtoResponse) {
                        PayConfigModel.this.b(((ClientConfigHttpProtoResponse) responsedMessage).getData());
                    } else if (responsedMessage instanceof ClientConfigSocketResponse) {
                        PayConfigModel.this.b(((ClientConfigSocketResponse) responsedMessage).getData());
                    }
                }
            }
        };
        this.aII = aVar;
        registerListener(this.aIJ);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void FX() {
        if (!c.FY().FZ()) {
            if (this.aII != null) {
                this.aII.FV();
                return;
            }
            return;
        }
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType("payType");
        sendMessage(clientConfigNetMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aIJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        if (dataRes == null || dataRes.payType == null) {
            if (this.aII != null) {
                this.aII.onError(TbadkCoreApplication.getInst().getString(d.l.data_load_error));
            }
        } else if (dataRes.payType.pay_type.intValue() == 1) {
            if (this.aII != null) {
                this.aII.FW();
            }
        } else if (dataRes.payType.pay_type.intValue() == 2) {
            if (this.aII != null) {
                this.aII.FV();
            }
        } else if (this.aII != null) {
            this.aII.onError("");
        }
    }
}
