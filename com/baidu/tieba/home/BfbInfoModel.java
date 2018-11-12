package com.baidu.tieba.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class BfbInfoModel extends BdBaseModel<CreateBarGuideActivity> {
    com.baidu.adp.framework.listener.a cWD;
    private a eik;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, UserBfbInfo userBfbInfo);
    }

    public BfbInfoModel(CreateBarGuideActivity createBarGuideActivity) {
        super(createBarGuideActivity.getPageContext());
        this.cWD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BFB_INFO, 309366) { // from class: com.baidu.tieba.home.BfbInfoModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof BfbInfoHttpResponseMessage) || (responsedMessage instanceof BfbInfoSocketResponseMessage)) {
                        UserBfbInfo userBfbInfo = null;
                        if (responsedMessage.getError() != 0) {
                            if (BfbInfoModel.this.eik != null) {
                                BfbInfoModel.this.eik.a(responsedMessage.getError(), responsedMessage.getErrorString(), null);
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof BfbInfoHttpResponseMessage) {
                            userBfbInfo = ((BfbInfoHttpResponseMessage) responsedMessage).getBfbInfo();
                        } else if (responsedMessage instanceof BfbInfoSocketResponseMessage) {
                            userBfbInfo = ((BfbInfoSocketResponseMessage) responsedMessage).getBfbInfo();
                        }
                        if (BfbInfoModel.this.eik != null) {
                            BfbInfoModel.this.eik.a(responsedMessage.getError(), responsedMessage.getErrorString(), userBfbInfo);
                        }
                    }
                }
            }
        };
        aHW();
        amu();
    }

    private void aHW() {
        com.baidu.tieba.tbadkCore.a.a.a(309366, BfbInfoSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309366, CmdConfigHttp.CMD_GET_BFB_INFO, TbConfig.GET_BFB_INFO, BfbInfoHttpResponseMessage.class, false, false, false, false);
    }

    private void amu() {
        registerListener(this.cWD);
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
        this.eik = aVar;
    }

    public void aHX() {
        MessageManager.getInstance().unRegisterListener(this.cWD);
        MessageManager.getInstance().unRegisterTask(309366);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_BFB_INFO);
    }
}
