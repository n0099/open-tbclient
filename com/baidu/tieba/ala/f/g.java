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
import com.baidu.tieba.ala.message.AlaGetRedPacketInfoResponseMessage;
import com.baidu.tieba.ala.message.AlaSnatchRedPacketResponseMessage;
/* loaded from: classes4.dex */
public class g extends BdBaseModel {
    private a flh;
    private HttpMessageListener gCb;
    private HttpMessageListener gCc;

    /* loaded from: classes4.dex */
    public interface a {
        void aC(int i, String str);

        void aD(int i, String str);

        void b(com.baidu.tieba.ala.data.c cVar);

        void b(com.baidu.tieba.ala.data.j jVar);
    }

    public g(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.gCb = new HttpMessageListener(1021160) { // from class: com.baidu.tieba.ala.f.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021160 && (httpResponsedMessage instanceof AlaGetRedPacketInfoResponseMessage)) {
                    AlaGetRedPacketInfoResponseMessage alaGetRedPacketInfoResponseMessage = (AlaGetRedPacketInfoResponseMessage) httpResponsedMessage;
                    if (g.this.flh != null) {
                        if (alaGetRedPacketInfoResponseMessage.getError() != 0 || !alaGetRedPacketInfoResponseMessage.isSuccess()) {
                            g.this.flh.aC(alaGetRedPacketInfoResponseMessage.getError(), alaGetRedPacketInfoResponseMessage.getErrorString());
                        } else {
                            g.this.flh.b(alaGetRedPacketInfoResponseMessage.bNO());
                        }
                    }
                }
            }
        };
        this.gCc = new HttpMessageListener(1021161) { // from class: com.baidu.tieba.ala.f.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021161 && (httpResponsedMessage instanceof AlaSnatchRedPacketResponseMessage)) {
                    AlaSnatchRedPacketResponseMessage alaSnatchRedPacketResponseMessage = (AlaSnatchRedPacketResponseMessage) httpResponsedMessage;
                    if (g.this.flh != null) {
                        com.baidu.tieba.ala.data.j bNQ = alaSnatchRedPacketResponseMessage.bNQ();
                        if (alaSnatchRedPacketResponseMessage.getError() != 0 || !alaSnatchRedPacketResponseMessage.isSuccess()) {
                            g.this.flh.aD(alaSnatchRedPacketResponseMessage.getError(), alaSnatchRedPacketResponseMessage.getErrorString());
                        } else {
                            g.this.flh.b(bNQ);
                        }
                    }
                }
            }
        };
        this.flh = aVar;
        initTasks();
        registerListener(this.gCb);
        registerListener(this.gCc);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021160, TbConfig.SERVER_HOST + "liveserver/redpacket/getredpacketinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetRedPacketInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1021161, TbConfig.SERVER_HOST + "liveserver/redpacket/lootredpacket");
        tbHttpMessageTask2.setIsNeedLogin(true);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask2.setResponsedClass(AlaSnatchRedPacketResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public void ak(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(1021160);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("redpacket_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("anchor_id", str3);
        sendMessage(httpMessage);
    }

    public void al(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(1021161);
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
        MessageManager.getInstance().unRegisterListener(this.gCc);
        MessageManager.getInstance().unRegisterListener(this.gCb);
        MessageManager.getInstance().unRegisterTask(1021161);
        MessageManager.getInstance().unRegisterTask(1021160);
    }
}
