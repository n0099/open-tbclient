package com.baidu.tieba.ala.g;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.message.AlaGetChallengeHistoryListResponseMessage;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private a gwt;
    private HttpMessageListener hsC;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, String str, Object obj);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.hsC = new HttpMessageListener(1021118) { // from class: com.baidu.tieba.ala.g.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetChallengeHistoryListResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == b.this.unique_id) {
                    b.this.gwt.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
                }
            }
        };
        this.gwt = aVar;
        registerTask();
        registerListener(this.hsC);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021118, TbConfig.SERVER_ADDRESS + "ala/web/pk/getPkHistory");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetChallengeHistoryListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void Ii(String str) {
        HttpMessage httpMessage = new HttpMessage(1021118);
        httpMessage.addParam("portrait", str);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("ps", 100);
        httpMessage.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1021118);
    }
}
