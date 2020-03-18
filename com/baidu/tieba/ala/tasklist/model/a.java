package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.v;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
/* loaded from: classes3.dex */
public class a extends BdBaseModel<AlaTaskListActivity> {
    private AlaLiveUserInfoData fAu;
    private v fAv;
    private InterfaceC0485a fAw;
    private HttpMessageListener fAx;
    private HttpMessageListener fAy;

    /* renamed from: com.baidu.tieba.ala.tasklist.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0485a {
        void a(AlaLiveUserInfoData alaLiveUserInfoData, v vVar);

        void ag(int i, String str);
    }

    public a(TbPageContext<AlaTaskListActivity> tbPageContext) {
        super(tbPageContext);
        this.fAx = new HttpMessageListener(1021065) { // from class: com.baidu.tieba.ala.tasklist.model.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021065 && (httpResponsedMessage instanceof AlaTaskListHttpResponsedMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    AlaTaskListHttpResponsedMessage alaTaskListHttpResponsedMessage = (AlaTaskListHttpResponsedMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        if (a.this.fAw != null) {
                            a.this.fAw.ag(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.fAu = alaTaskListHttpResponsedMessage.fAu;
                    a.this.fAv = alaTaskListHttpResponsedMessage.fAv;
                    if (a.this.fAw != null) {
                        a.this.fAw.a(alaTaskListHttpResponsedMessage.fAu, alaTaskListHttpResponsedMessage.fAv);
                    }
                }
            }
        };
        this.fAy = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.tasklist.model.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        if (a.this.fAw != null) {
                            a.this.fAw.ag(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.fAu = alaTaskRewardHttpResponsedMessage.fAu;
                    a.this.fAv = alaTaskRewardHttpResponsedMessage.fAv;
                    if (a.this.fAw != null) {
                        a.this.fAw.a(alaTaskRewardHttpResponsedMessage.fAu, alaTaskRewardHttpResponsedMessage.fAv);
                    }
                }
            }
        };
        btC();
        btD();
        MessageManager.getInstance().registerListener(this.fAx);
        MessageManager.getInstance().registerListener(this.fAy);
    }

    public v btB() {
        return this.fAv;
    }

    private void btC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021065, com.baidu.live.a.VA);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaTaskListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void btD() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021066, com.baidu.live.a.VB);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaTaskRewardHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void btE() {
        HttpMessage httpMessage = new HttpMessage(1021065);
        httpMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void qV(int i) {
        HttpMessage httpMessage = new HttpMessage(1021066);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("task_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fAx);
        MessageManager.getInstance().unRegisterListener(this.fAy);
        MessageManager.getInstance().unRegisterTask(1021065);
        MessageManager.getInstance().unRegisterTask(1021066);
        cancelMessage();
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void a(InterfaceC0485a interfaceC0485a) {
        this.fAw = interfaceC0485a;
    }
}
