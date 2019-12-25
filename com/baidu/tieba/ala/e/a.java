package com.baidu.tieba.ala.e;

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
/* loaded from: classes2.dex */
public class a extends BdBaseModel {
    private InterfaceC0416a evI;
    private HttpMessageListener fjv;

    /* renamed from: com.baidu.tieba.ala.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0416a {
        void a(int i, String str, Object obj);
    }

    public a(TbPageContext tbPageContext, InterfaceC0416a interfaceC0416a) {
        super(tbPageContext);
        this.fjv = new HttpMessageListener(1021118) { // from class: com.baidu.tieba.ala.e.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetChallengeHistoryListResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                    a.this.evI.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
                }
            }
        };
        this.evI = interfaceC0416a;
        rG();
        registerListener(this.fjv);
    }

    private void rG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021118, TbConfig.SERVER_ADDRESS + "ala/web/pk/getPkHistory");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetChallengeHistoryListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void yW(String str) {
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
