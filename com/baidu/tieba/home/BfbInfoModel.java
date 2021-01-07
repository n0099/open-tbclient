package com.baidu.tieba.home;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import tbclient.UserBfbInfo;
/* loaded from: classes8.dex */
public class BfbInfoModel extends BdBaseModel<CreateBarGuideActivity> {
    private a jVf;
    com.baidu.adp.framework.listener.a jaH;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String str, UserBfbInfo userBfbInfo);
    }

    public BfbInfoModel(CreateBarGuideActivity createBarGuideActivity) {
        super(createBarGuideActivity.getPageContext());
        this.jaH = new com.baidu.adp.framework.listener.a(1003100, CmdConfigSocket.CMD_GET_BFB_INFO) { // from class: com.baidu.tieba.home.BfbInfoModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof BfbInfoHttpResponseMessage) || (responsedMessage instanceof BfbInfoSocketResponseMessage)) {
                        UserBfbInfo userBfbInfo = null;
                        if (responsedMessage.getError() != 0) {
                            if (BfbInfoModel.this.jVf != null) {
                                BfbInfoModel.this.jVf.a(responsedMessage.getError(), responsedMessage.getErrorString(), null);
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof BfbInfoHttpResponseMessage) {
                            userBfbInfo = ((BfbInfoHttpResponseMessage) responsedMessage).getBfbInfo();
                        } else if (responsedMessage instanceof BfbInfoSocketResponseMessage) {
                            userBfbInfo = ((BfbInfoSocketResponseMessage) responsedMessage).getBfbInfo();
                        }
                        if (BfbInfoModel.this.jVf != null) {
                            BfbInfoModel.this.jVf.a(responsedMessage.getError(), responsedMessage.getErrorString(), userBfbInfo);
                        }
                    }
                }
            }
        };
        cQp();
        cmS();
    }

    private void cQp() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_BFB_INFO, BfbInfoSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_BFB_INFO, 1003100, TbConfig.GET_BFB_INFO, BfbInfoHttpResponseMessage.class, false, false, false, false);
    }

    private void cmS() {
        registerListener(this.jaH);
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
        this.jVf = aVar;
    }

    public void cQq() {
        MessageManager.getInstance().unRegisterListener(this.jaH);
        MessageManager.getInstance().unRegisterTask(CmdConfigSocket.CMD_GET_BFB_INFO);
        MessageManager.getInstance().unRegisterTask(1003100);
    }
}
