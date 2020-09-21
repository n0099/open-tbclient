package com.baidu.tieba.ala.g;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.data.c;
import com.baidu.tieba.ala.message.AlaGetRedPacketInfoResponseMessage;
import com.baidu.tieba.ala.message.AlaSnatchRedPacketResponseMessage;
/* loaded from: classes4.dex */
public class h extends BdBaseModel {
    private a fzR;
    private HttpMessageListener gRX;
    private HttpMessageListener gRY;

    /* loaded from: classes4.dex */
    public interface a {
        void aA(int i, String str);

        void aB(int i, String str);

        void b(com.baidu.tieba.ala.data.c cVar);

        void b(com.baidu.tieba.ala.data.j jVar);
    }

    public h(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.gRX = new HttpMessageListener(1021160) { // from class: com.baidu.tieba.ala.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021160 && (httpResponsedMessage instanceof AlaGetRedPacketInfoResponseMessage)) {
                    AlaGetRedPacketInfoResponseMessage alaGetRedPacketInfoResponseMessage = (AlaGetRedPacketInfoResponseMessage) httpResponsedMessage;
                    long logId = alaGetRedPacketInfoResponseMessage.getLogId();
                    AlaStatsItem alaStatsItem = new AlaStatsItem();
                    alaStatsItem.addValue(BaseJsonData.TAG_ERRNO, Integer.valueOf(alaGetRedPacketInfoResponseMessage.getError()));
                    if (alaGetRedPacketInfoResponseMessage.bZw() != null) {
                        com.baidu.tieba.ala.data.i iVar = alaGetRedPacketInfoResponseMessage.bZw().fXy;
                        if (iVar != null) {
                            alaStatsItem.addValue("redpacketId", iVar.id);
                            alaStatsItem.addValue("status", Integer.valueOf(iVar.status));
                        }
                        c.a aVar2 = alaGetRedPacketInfoResponseMessage.bZw().fXz;
                        if (aVar2 != null) {
                            alaStatsItem.addValue("needFollow", aVar2.fXC ? "1" : "0");
                            alaStatsItem.addValue("hasFollowed", aVar2.isFollowed ? "1" : "0");
                            alaStatsItem.addValue("needSendGift", aVar2.fXD ? "1" : "0");
                            alaStatsItem.addValue("hasSendGift", aVar2.fXE ? "1" : "0");
                            alaStatsItem.addValue("myLootResult", Integer.valueOf(aVar2.fXA));
                            alaStatsItem.addValue("myLootAmount", Long.valueOf(aVar2.fXB));
                        }
                    }
                    AlaStatManager.getInstance().debug("redpacket_get_info", logId, "", alaStatsItem);
                    if (h.this.fzR != null) {
                        if (alaGetRedPacketInfoResponseMessage.getError() != 0 || !alaGetRedPacketInfoResponseMessage.isSuccess()) {
                            h.this.fzR.aA(alaGetRedPacketInfoResponseMessage.getError(), alaGetRedPacketInfoResponseMessage.getErrorString());
                        } else {
                            h.this.fzR.b(alaGetRedPacketInfoResponseMessage.bZw());
                        }
                    }
                }
            }
        };
        this.gRY = new HttpMessageListener(1021161) { // from class: com.baidu.tieba.ala.g.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021161 && (httpResponsedMessage instanceof AlaSnatchRedPacketResponseMessage)) {
                    AlaSnatchRedPacketResponseMessage alaSnatchRedPacketResponseMessage = (AlaSnatchRedPacketResponseMessage) httpResponsedMessage;
                    long logId = alaSnatchRedPacketResponseMessage.getLogId();
                    AlaStatsItem alaStatsItem = new AlaStatsItem();
                    alaStatsItem.addValue(BaseJsonData.TAG_ERRNO, Integer.valueOf(alaSnatchRedPacketResponseMessage.getError()));
                    com.baidu.tieba.ala.data.j bZy = alaSnatchRedPacketResponseMessage.bZy();
                    if (bZy != null) {
                        alaStatsItem.addValue("result", bZy.bJY() ? "1" : "0");
                        alaStatsItem.addValue("resultAmount", Long.valueOf(bZy.bJZ()));
                    }
                    AlaStatManager.getInstance().debug("redpacket_loot_result", logId, "", alaStatsItem);
                    if (h.this.fzR != null) {
                        com.baidu.tieba.ala.data.j bZy2 = alaSnatchRedPacketResponseMessage.bZy();
                        if (alaSnatchRedPacketResponseMessage.getError() != 0 || !alaSnatchRedPacketResponseMessage.isSuccess()) {
                            h.this.fzR.aB(alaSnatchRedPacketResponseMessage.getError(), alaSnatchRedPacketResponseMessage.getErrorString());
                        } else {
                            h.this.fzR.b(bZy2);
                        }
                    }
                }
            }
        };
        this.fzR = aVar;
        initTasks();
        registerListener(this.gRX);
        registerListener(this.gRY);
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
        MessageManager.getInstance().unRegisterListener(this.gRY);
        MessageManager.getInstance().unRegisterListener(this.gRX);
        MessageManager.getInstance().unRegisterTask(1021161);
        MessageManager.getInstance().unRegisterTask(1021160);
    }
}
