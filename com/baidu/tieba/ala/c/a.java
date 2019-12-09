package com.baidu.tieba.ala.c;

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
/* loaded from: classes6.dex */
public class a extends BdBaseModel {
    private InterfaceC0333a dHw;
    private HttpMessageListener esq;

    /* renamed from: com.baidu.tieba.ala.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0333a {
        void a(int i, String str, Object obj);
    }

    public a(TbPageContext tbPageContext, InterfaceC0333a interfaceC0333a) {
        super(tbPageContext);
        this.esq = new HttpMessageListener(1021118) { // from class: com.baidu.tieba.ala.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetChallengeHistoryListResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    a.this.dHw.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
                }
            }
        };
        this.dHw = interfaceC0333a;
        registerTask();
        registerListener(this.esq);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021118, TbConfig.SERVER_ADDRESS + "ala/web/pk/getPkHistory");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetChallengeHistoryListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void uf(String str) {
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
