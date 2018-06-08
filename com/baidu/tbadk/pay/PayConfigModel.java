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
/* loaded from: classes2.dex */
public class PayConfigModel extends BdBaseModel {
    private a aSv;
    private final com.baidu.adp.framework.listener.a aSw;

    public PayConfigModel(BaseActivity<?> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.aSw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039) { // from class: com.baidu.tbadk.pay.PayConfigModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (PayConfigModel.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(d.k.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        if (PayConfigModel.this.aSv != null) {
                            PayConfigModel.this.aSv.onError(string);
                        }
                    } else if (responsedMessage instanceof ClientConfigHttpProtoResponse) {
                        PayConfigModel.this.b(((ClientConfigHttpProtoResponse) responsedMessage).getData());
                    } else if (responsedMessage instanceof ClientConfigSocketResponse) {
                        PayConfigModel.this.b(((ClientConfigSocketResponse) responsedMessage).getData());
                    }
                }
            }
        };
        this.aSv = aVar;
        registerListener(this.aSw);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void Ke() {
        if (!c.Kf().Kg()) {
            if (this.aSv != null) {
                this.aSv.Kc();
                return;
            }
            return;
        }
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType("payType");
        sendMessage(clientConfigNetMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aSw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        if (dataRes == null || dataRes.payType == null) {
            if (this.aSv != null) {
                this.aSv.onError(TbadkCoreApplication.getInst().getString(d.k.data_load_error));
            }
        } else if (dataRes.payType.pay_type.intValue() == 1) {
            if (this.aSv != null) {
                this.aSv.Kd();
            }
        } else if (dataRes.payType.pay_type.intValue() == 2) {
            if (this.aSv != null) {
                this.aSv.Kc();
            }
        } else if (this.aSv != null) {
            this.aSv.onError("");
        }
    }
}
