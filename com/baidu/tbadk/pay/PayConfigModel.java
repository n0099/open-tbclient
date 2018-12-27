package com.baidu.tbadk.pay;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigNetMessage;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.e;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes6.dex */
public class PayConfigModel extends BdBaseModel {
    private a bfw;
    private final com.baidu.adp.framework.listener.a bfx;

    public PayConfigModel(BaseActivity<?> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        this.bfx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039) { // from class: com.baidu.tbadk.pay.PayConfigModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (PayConfigModel.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(e.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        if (PayConfigModel.this.bfw != null) {
                            PayConfigModel.this.bfw.onError(string);
                        }
                    } else if (responsedMessage instanceof ClientConfigHttpProtoResponse) {
                        PayConfigModel.this.b(((ClientConfigHttpProtoResponse) responsedMessage).getData());
                    } else if (responsedMessage instanceof ClientConfigSocketResponse) {
                        PayConfigModel.this.b(((ClientConfigSocketResponse) responsedMessage).getData());
                    }
                }
            }
        };
        this.bfw = aVar;
        registerListener(this.bfx);
    }

    public PayConfigModel(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.bfx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039) { // from class: com.baidu.tbadk.pay.PayConfigModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (PayConfigModel.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                        String errorString = responsedMessage.getErrorString();
                        String string = TbadkCoreApplication.getInst().getString(e.j.neterror);
                        if (!StringUtils.isNull(errorString)) {
                            string = errorString;
                        }
                        if (PayConfigModel.this.bfw != null) {
                            PayConfigModel.this.bfw.onError(string);
                        }
                    } else if (responsedMessage instanceof ClientConfigHttpProtoResponse) {
                        PayConfigModel.this.b(((ClientConfigHttpProtoResponse) responsedMessage).getData());
                    } else if (responsedMessage instanceof ClientConfigSocketResponse) {
                        PayConfigModel.this.b(((ClientConfigSocketResponse) responsedMessage).getData());
                    }
                }
            }
        };
        this.bfw = aVar;
        registerListener(this.bfx);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void OX() {
        if (!c.OY().OZ()) {
            if (this.bfw != null) {
                this.bfw.OV();
                return;
            }
            return;
        }
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType("payType");
        sendMessage(clientConfigNetMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bfx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        if (dataRes == null || dataRes.payType == null) {
            if (this.bfw != null) {
                this.bfw.onError(TbadkCoreApplication.getInst().getString(e.j.data_load_error));
            }
        } else if (dataRes.payType.pay_type.intValue() == 1) {
            if (this.bfw != null) {
                this.bfw.OW();
            }
        } else if (dataRes.payType.pay_type.intValue() == 2) {
            if (this.bfw != null) {
                this.bfw.OV();
            }
        } else if (this.bfw != null) {
            this.bfw.onError("");
        }
    }
}
