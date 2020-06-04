package com.baidu.tieba.ala.f;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
/* loaded from: classes3.dex */
public class i extends BdBaseModel {
    private j fuo;
    private HttpMessageListener gjJ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST) { // from class: com.baidu.tieba.ala.f.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetHourRankListResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && i.this.fuo != null) {
                i.this.fuo.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    public i(BdUniqueId bdUniqueId, j jVar) {
        this.unique_id = bdUniqueId;
        this.fuo = jVar;
        Fv();
        registerListener(this.gjJ);
    }

    private void Fv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST, com.baidu.live.a.ass);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetHourRankListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void h(long j, String str) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            a(j, str, 0, 0, this.unique_id);
        }
    }

    public void a(long j, String str, int i, int i2, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("rank_time_tag", str);
        httpMessage.addParam("need_bro", i);
        httpMessage.addParam("force_rt", i2);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
