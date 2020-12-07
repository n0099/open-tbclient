package com.baidu.tieba.frs.live;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes22.dex */
public class c {
    private a jqK;
    private HttpMessageListener jqP = new HttpMessageListener(1001713) { // from class: com.baidu.tieba.frs.live.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof FrsLiveTipResponseMessage) && httpResponsedMessage.getError() == 0 && c.this.jqK != null) {
                c.this.jqK.a((FrsLiveTipResponseMessage) httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage);
    }

    public c(a aVar) {
        this.jqK = aVar;
        registerTask();
        MessageManager.getInstance().registerListener(this.jqP);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001713, TbConfig.FRS_LIVE_TIP_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsLiveTipResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void Bj(int i) {
        HttpMessage httpMessage = new HttpMessage(1001713);
        httpMessage.addParam("forum_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterTask(1001713);
        MessageManager.getInstance().unRegisterListener(this.jqP);
    }
}
