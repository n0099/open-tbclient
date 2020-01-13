package com.baidu.tieba.frs.live;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes7.dex */
public class c {
    private a gEf;
    private HttpMessageListener gEj = new HttpMessageListener(1001713) { // from class: com.baidu.tieba.frs.live.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof FrsLiveTipResponseMessage) && httpResponsedMessage.getError() == 0 && c.this.gEf != null) {
                c.this.gEf.a((FrsLiveTipResponseMessage) httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage);
    }

    public c(a aVar) {
        this.gEf = aVar;
        rT();
        MessageManager.getInstance().registerListener(this.gEj);
    }

    private void rT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001713, TbConfig.FRS_LIVE_TIP_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsLiveTipResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void tF(int i) {
        HttpMessage httpMessage = new HttpMessage(1001713);
        httpMessage.addParam("forum_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterTask(1001713);
        MessageManager.getInstance().unRegisterListener(this.gEj);
    }
}
