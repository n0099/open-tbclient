package com.baidu.tieba.ala.g;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetRankListResponseMessage;
import com.baidu.tieba.ala.message.AlaGetUserRankInfoResponseMessage;
/* loaded from: classes4.dex */
public class f extends BdBaseModel {
    private HttpMessageListener gRR = new HttpMessageListener(1021068) { // from class: com.baidu.tieba.ala.g.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetRankListResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == f.this.unique_id) {
                f.this.gai.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener gRS = new HttpMessageListener(1021070) { // from class: com.baidu.tieba.ala.g.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetUserRankInfoResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == f.this.unique_id) {
                f.this.gai.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener gRT = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST) { // from class: com.baidu.tieba.ala.g.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetHourRankListResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && f.this.gai != null) {
                f.this.gai.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };
    private n gai;

    public f(BdUniqueId bdUniqueId, n nVar) {
        this.unique_id = bdUniqueId;
        this.gai = nVar;
        registerTask();
        registerListener(this.gRR);
        registerListener(this.gRS);
        registerListener(this.gRT);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021068, com.baidu.live.a.azj);
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetRankListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1021070, com.baidu.live.a.azk);
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask2.setResponsedClass(AlaGetUserRankInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST, com.baidu.live.a.azm);
        tbHttpMessageTask3.setIsNeedLogin(false);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask3.setRetry(1);
        tbHttpMessageTask3.setResponsedClass(AlaGetHourRankListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
    }

    public void e(String str, long j, String str2) {
        if (TextUtils.equals(str, "charm_day")) {
            HttpMessage httpMessage = new HttpMessage(1021068);
            httpMessage.addParam("type", SdkStaticKeys.RANK_TYPE_CHARM);
            httpMessage.addParam(Config.PACKAGE_NAME, 1);
            httpMessage.addParam("ps", 100);
            httpMessage.addParam("time", "day");
            httpMessage.addParam("rt", 1);
            httpMessage.addParam("merge", 1);
            httpMessage.setTag(this.unique_id);
            MessageManager.getInstance().sendMessage(httpMessage);
        } else if (TextUtils.equals(str, "hour")) {
            HttpMessage httpMessage2 = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
            httpMessage2.addParam("user_id", j);
            httpMessage2.addParam("rank_time_tag", str2);
            httpMessage2.addParam("need_bro", 1);
            httpMessage2.addParam("force_rt", 0);
            httpMessage2.setTag(this.unique_id);
            MessageManager.getInstance().sendMessage(httpMessage2);
        }
    }

    public void a(String str, long j, String str2, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("rank_time_tag", str2);
        httpMessage.addParam("need_bro", 1);
        httpMessage.addParam("force_rt", 0);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void x(String str, long j) {
        HttpMessage httpMessage = new HttpMessage(1021070);
        httpMessage.addParam("type", str);
        httpMessage.addParam("time", "day");
        httpMessage.addParam("user_id", j);
        httpMessage.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterTask(1021068);
        MessageManager.getInstance().unRegisterTask(1021070);
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
