package com.baidu.tieba.ala.e;

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
/* loaded from: classes3.dex */
public class e extends BdBaseModel {
    private k eix;
    private HttpMessageListener fpI;

    public e(BdPageContext<?> bdPageContext, k kVar) {
        super(bdPageContext);
        this.fpI = new HttpMessageListener(1021162) { // from class: com.baidu.tieba.ala.e.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021162 && (httpResponsedMessage instanceof AlaLootRedPacketResultResponseMessage)) {
                    AlaLootRedPacketResultResponseMessage alaLootRedPacketResultResponseMessage = (AlaLootRedPacketResultResponseMessage) httpResponsedMessage;
                    if (e.this.eix != null) {
                        if (alaLootRedPacketResultResponseMessage.getError() != 0 || !alaLootRedPacketResultResponseMessage.isSuccess()) {
                            e.this.eix.ad(alaLootRedPacketResultResponseMessage.getError(), alaLootRedPacketResultResponseMessage.getErrorString());
                        } else {
                            e.this.eix.b(alaLootRedPacketResultResponseMessage.brC());
                        }
                    }
                }
            }
        };
        this.eix = kVar;
        initTasks();
        registerListener(this.fpI);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021162, TbConfig.SERVER_HOST + "liveserver/redpacket/getredpacketresultlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaLootRedPacketResultResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void ae(String str, String str2, String str3) {
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
        MessageManager.getInstance().unRegisterListener(this.fpI);
        MessageManager.getInstance().unRegisterTask(1021162);
    }
}
