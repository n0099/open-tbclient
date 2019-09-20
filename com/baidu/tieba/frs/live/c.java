package com.baidu.tieba.frs.live;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class c {
    private a fOf;
    private HttpMessageListener fOj = new HttpMessageListener(CmdConfigHttp.FRS_LIVE_TIP_CMD) { // from class: com.baidu.tieba.frs.live.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof FrsLiveTipResponseMessage) && httpResponsedMessage.getError() == 0 && c.this.fOf != null) {
                c.this.fOf.a((FrsLiveTipResponseMessage) httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage);
    }

    public c(a aVar) {
        this.fOf = aVar;
        registerTask();
        MessageManager.getInstance().registerListener(this.fOj);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LIVE_TIP_CMD, TbConfig.FRS_LIVE_TIP_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsLiveTipResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void sC(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_LIVE_TIP_CMD);
        httpMessage.addParam("forum_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_LIVE_TIP_CMD);
        MessageManager.getInstance().unRegisterListener(this.fOj);
    }
}
