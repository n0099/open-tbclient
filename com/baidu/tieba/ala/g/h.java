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
    private a fMa;
    private HttpMessageListener hgU;
    private HttpMessageListener hgV;

    /* loaded from: classes4.dex */
    public interface a {
        void aL(int i, String str);

        void aM(int i, String str);

        void b(com.baidu.tieba.ala.data.c cVar);

        void b(com.baidu.tieba.ala.data.j jVar);
    }

    public h(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.hgU = new HttpMessageListener(1021160) { // from class: com.baidu.tieba.ala.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021160 && (httpResponsedMessage instanceof AlaGetRedPacketInfoResponseMessage)) {
                    AlaGetRedPacketInfoResponseMessage alaGetRedPacketInfoResponseMessage = (AlaGetRedPacketInfoResponseMessage) httpResponsedMessage;
                    long logId = alaGetRedPacketInfoResponseMessage.getLogId();
                    AlaStatsItem alaStatsItem = new AlaStatsItem();
                    alaStatsItem.addValue(BaseJsonData.TAG_ERRNO, Integer.valueOf(alaGetRedPacketInfoResponseMessage.getError()));
                    if (alaGetRedPacketInfoResponseMessage.ccU() != null) {
                        com.baidu.tieba.ala.data.i iVar = alaGetRedPacketInfoResponseMessage.ccU().gjR;
                        if (iVar != null) {
                            alaStatsItem.addValue("redpacketId", iVar.id);
                            alaStatsItem.addValue("status", Integer.valueOf(iVar.status));
                        }
                        c.a aVar2 = alaGetRedPacketInfoResponseMessage.ccU().gjS;
                        if (aVar2 != null) {
                            alaStatsItem.addValue("needFollow", aVar2.gjV ? "1" : "0");
                            alaStatsItem.addValue("hasFollowed", aVar2.isFollowed ? "1" : "0");
                            alaStatsItem.addValue("needSendGift", aVar2.gjW ? "1" : "0");
                            alaStatsItem.addValue("hasSendGift", aVar2.gjX ? "1" : "0");
                            alaStatsItem.addValue("myLootResult", Integer.valueOf(aVar2.gjT));
                            alaStatsItem.addValue("myLootAmount", Long.valueOf(aVar2.gjU));
                        }
                    }
                    AlaStatManager.getInstance().debug("redpacket_get_info", logId, "", alaStatsItem);
                    if (h.this.fMa != null) {
                        if (alaGetRedPacketInfoResponseMessage.getError() != 0 || !alaGetRedPacketInfoResponseMessage.isSuccess()) {
                            h.this.fMa.aL(alaGetRedPacketInfoResponseMessage.getError(), alaGetRedPacketInfoResponseMessage.getErrorString());
                        } else {
                            h.this.fMa.b(alaGetRedPacketInfoResponseMessage.ccU());
                        }
                    }
                }
            }
        };
        this.hgV = new HttpMessageListener(1021161) { // from class: com.baidu.tieba.ala.g.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021161 && (httpResponsedMessage instanceof AlaSnatchRedPacketResponseMessage)) {
                    AlaSnatchRedPacketResponseMessage alaSnatchRedPacketResponseMessage = (AlaSnatchRedPacketResponseMessage) httpResponsedMessage;
                    long logId = alaSnatchRedPacketResponseMessage.getLogId();
                    AlaStatsItem alaStatsItem = new AlaStatsItem();
                    alaStatsItem.addValue(BaseJsonData.TAG_ERRNO, Integer.valueOf(alaSnatchRedPacketResponseMessage.getError()));
                    com.baidu.tieba.ala.data.j ccW = alaSnatchRedPacketResponseMessage.ccW();
                    if (ccW != null) {
                        alaStatsItem.addValue("result", ccW.bMI() ? "1" : "0");
                        alaStatsItem.addValue("resultAmount", Long.valueOf(ccW.bMJ()));
                    }
                    AlaStatManager.getInstance().debug("redpacket_loot_result", logId, "", alaStatsItem);
                    if (h.this.fMa != null) {
                        com.baidu.tieba.ala.data.j ccW2 = alaSnatchRedPacketResponseMessage.ccW();
                        if (alaSnatchRedPacketResponseMessage.getError() != 0 || !alaSnatchRedPacketResponseMessage.isSuccess()) {
                            h.this.fMa.aM(alaSnatchRedPacketResponseMessage.getError(), alaSnatchRedPacketResponseMessage.getErrorString());
                        } else {
                            h.this.fMa.b(ccW2);
                        }
                    }
                }
            }
        };
        this.fMa = aVar;
        initTasks();
        registerListener(this.hgU);
        registerListener(this.hgV);
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

    public void am(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(1021160);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("redpacket_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("anchor_id", str3);
        sendMessage(httpMessage);
    }

    public void an(String str, String str2, String str3) {
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
        MessageManager.getInstance().unRegisterListener(this.hgV);
        MessageManager.getInstance().unRegisterListener(this.hgU);
        MessageManager.getInstance().unRegisterTask(1021161);
        MessageManager.getInstance().unRegisterTask(1021160);
    }
}
