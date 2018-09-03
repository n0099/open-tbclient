package com.baidu.tieba.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class BfbInfoModel extends BdBaseModel<CreateBarGuideActivity> {
    com.baidu.adp.framework.listener.a cHp;
    private a dRF;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, UserBfbInfo userBfbInfo);
    }

    public BfbInfoModel(CreateBarGuideActivity createBarGuideActivity) {
        super(createBarGuideActivity.getPageContext());
        this.cHp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BFB_INFO, 309366) { // from class: com.baidu.tieba.home.BfbInfoModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof BfbInfoHttpResponseMessage) || (responsedMessage instanceof BfbInfoSocketResponseMessage)) {
                        UserBfbInfo userBfbInfo = null;
                        if (responsedMessage.getError() != 0) {
                            if (BfbInfoModel.this.dRF != null) {
                                BfbInfoModel.this.dRF.a(responsedMessage.getError(), responsedMessage.getErrorString(), null);
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof BfbInfoHttpResponseMessage) {
                            userBfbInfo = ((BfbInfoHttpResponseMessage) responsedMessage).getBfbInfo();
                        } else if (responsedMessage instanceof BfbInfoSocketResponseMessage) {
                            userBfbInfo = ((BfbInfoSocketResponseMessage) responsedMessage).getBfbInfo();
                        }
                        if (BfbInfoModel.this.dRF != null) {
                            BfbInfoModel.this.dRF.a(responsedMessage.getError(), responsedMessage.getErrorString(), userBfbInfo);
                        }
                    }
                }
            }
        };
        aCT();
        ahE();
    }

    private void aCT() {
        com.baidu.tieba.tbadkCore.a.a.a(309366, BfbInfoSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309366, CmdConfigHttp.CMD_GET_BFB_INFO, TbConfig.GET_BFB_INFO, BfbInfoHttpResponseMessage.class, false, false, false, false);
    }

    private void ahE() {
        registerListener(this.cHp);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new BfbInfoRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.dRF = aVar;
    }

    public void aCU() {
        MessageManager.getInstance().unRegisterListener(this.cHp);
        MessageManager.getInstance().unRegisterTask(309366);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_BFB_INFO);
    }
}
