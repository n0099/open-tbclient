package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class c extends BdBaseModel {
    private HttpMessageListener htI;

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.htI = new HttpMessageListener(1021104) { // from class: com.baidu.tieba.ala.liveroom.challenge.rewarddialog.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaChallengeRewardResponseMessage)) {
                    AlaChallengeRewardResponseMessage alaChallengeRewardResponseMessage = (AlaChallengeRewardResponseMessage) httpResponsedMessage;
                    if (c.this.mLoadDataCallBack != null) {
                        c.this.mLoadDataCallBack.callback(alaChallengeRewardResponseMessage.htK);
                    }
                }
            }
        };
        initTasks();
        registerListener(this.htI);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021104, TbConfig.SERVER_ADDRESS + "ala/challenge/getChallengeResult");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaChallengeRewardResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void d(long j, long j2, long j3) {
        HttpMessage httpMessage = new HttpMessage(1021104);
        httpMessage.addParam("challenge_id", j);
        httpMessage.addParam("anchor_id", j2);
        httpMessage.addParam("live_id", j3);
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
}
