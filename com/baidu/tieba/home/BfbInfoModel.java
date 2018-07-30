package com.baidu.tieba.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class BfbInfoModel extends BdBaseModel<CreateBarGuideActivity> {
    com.baidu.adp.framework.listener.a cHs;
    private a dRK;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, UserBfbInfo userBfbInfo);
    }

    public BfbInfoModel(CreateBarGuideActivity createBarGuideActivity) {
        super(createBarGuideActivity.getPageContext());
        this.cHs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BFB_INFO, 309366) { // from class: com.baidu.tieba.home.BfbInfoModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof BfbInfoHttpResponseMessage) || (responsedMessage instanceof BfbInfoSocketResponseMessage)) {
                        UserBfbInfo userBfbInfo = null;
                        if (responsedMessage.getError() != 0) {
                            if (BfbInfoModel.this.dRK != null) {
                                BfbInfoModel.this.dRK.a(responsedMessage.getError(), responsedMessage.getErrorString(), null);
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof BfbInfoHttpResponseMessage) {
                            userBfbInfo = ((BfbInfoHttpResponseMessage) responsedMessage).getBfbInfo();
                        } else if (responsedMessage instanceof BfbInfoSocketResponseMessage) {
                            userBfbInfo = ((BfbInfoSocketResponseMessage) responsedMessage).getBfbInfo();
                        }
                        if (BfbInfoModel.this.dRK != null) {
                            BfbInfoModel.this.dRK.a(responsedMessage.getError(), responsedMessage.getErrorString(), userBfbInfo);
                        }
                    }
                }
            }
        };
        aCW();
        ahC();
    }

    private void aCW() {
        com.baidu.tieba.tbadkCore.a.a.a(309366, BfbInfoSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309366, CmdConfigHttp.CMD_GET_BFB_INFO, TbConfig.GET_BFB_INFO, BfbInfoHttpResponseMessage.class, false, false, false, false);
    }

    private void ahC() {
        registerListener(this.cHs);
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
        this.dRK = aVar;
    }

    public void aCX() {
        MessageManager.getInstance().unRegisterListener(this.cHs);
        MessageManager.getInstance().unRegisterTask(309366);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_BFB_INFO);
    }
}
