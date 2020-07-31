package com.baidu.tieba.ala.f;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.message.AlaLootRedPacketResultResponseMessage;
/* loaded from: classes4.dex */
public class f extends BdBaseModel {
    private l fkC;
    private HttpMessageListener gBZ;

    public f(BdPageContext<?> bdPageContext, l lVar) {
        super(bdPageContext);
        this.gBZ = new HttpMessageListener(1021162) { // from class: com.baidu.tieba.ala.f.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021162 && (httpResponsedMessage instanceof AlaLootRedPacketResultResponseMessage)) {
                    AlaLootRedPacketResultResponseMessage alaLootRedPacketResultResponseMessage = (AlaLootRedPacketResultResponseMessage) httpResponsedMessage;
                    if (f.this.fkC != null) {
                        if (alaLootRedPacketResultResponseMessage.getError() != 0 || !alaLootRedPacketResultResponseMessage.isSuccess()) {
                            f.this.fkC.aB(alaLootRedPacketResultResponseMessage.getError(), alaLootRedPacketResultResponseMessage.getErrorString());
                        } else {
                            f.this.fkC.b(alaLootRedPacketResultResponseMessage.bNP());
                        }
                    }
                }
            }
        };
        this.fkC = lVar;
        initTasks();
        registerListener(this.gBZ);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021162, TbConfig.SERVER_HOST + "liveserver/redpacket/getredpacketresultlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaLootRedPacketResultResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void aj(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(1021162);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("redpacket_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("anchor_id", str3);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gBZ);
        MessageManager.getInstance().unRegisterTask(1021162);
    }
}
