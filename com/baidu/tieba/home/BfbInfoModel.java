package com.baidu.tieba.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import tbclient.UserBfbInfo;
/* loaded from: classes24.dex */
public class BfbInfoModel extends BdBaseModel<CreateBarGuideActivity> {
    com.baidu.adp.framework.listener.a iCN;
    private a jtN;

    /* loaded from: classes24.dex */
    public interface a {
        void a(int i, String str, UserBfbInfo userBfbInfo);
    }

    public BfbInfoModel(CreateBarGuideActivity createBarGuideActivity) {
        super(createBarGuideActivity.getPageContext());
        this.iCN = new com.baidu.adp.framework.listener.a(1003100, CmdConfigSocket.CMD_GET_BFB_INFO) { // from class: com.baidu.tieba.home.BfbInfoModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof BfbInfoHttpResponseMessage) || (responsedMessage instanceof BfbInfoSocketResponseMessage)) {
                        UserBfbInfo userBfbInfo = null;
                        if (responsedMessage.getError() != 0) {
                            if (BfbInfoModel.this.jtN != null) {
                                BfbInfoModel.this.jtN.a(responsedMessage.getError(), responsedMessage.getErrorString(), null);
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof BfbInfoHttpResponseMessage) {
                            userBfbInfo = ((BfbInfoHttpResponseMessage) responsedMessage).getBfbInfo();
                        } else if (responsedMessage instanceof BfbInfoSocketResponseMessage) {
                            userBfbInfo = ((BfbInfoSocketResponseMessage) responsedMessage).getBfbInfo();
                        }
                        if (BfbInfoModel.this.jtN != null) {
                            BfbInfoModel.this.jtN.a(responsedMessage.getError(), responsedMessage.getErrorString(), userBfbInfo);
                        }
                    }
                }
            }
        };
        cIo();
        cgO();
    }

    private void cIo() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_BFB_INFO, BfbInfoSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_BFB_INFO, 1003100, TbConfig.GET_BFB_INFO, BfbInfoHttpResponseMessage.class, false, false, false, false);
    }

    private void cgO() {
        registerListener(this.iCN);
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
        this.jtN = aVar;
    }

    public void cIp() {
        MessageManager.getInstance().unRegisterListener(this.iCN);
        MessageManager.getInstance().unRegisterTask(CmdConfigSocket.CMD_GET_BFB_INFO);
        MessageManager.getInstance().unRegisterTask(1003100);
    }
}
