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
    private v fzA;
    private InterfaceC0485a fzB;
    private HttpMessageListener fzC;
    private HttpMessageListener fzD;
    private AlaLiveUserInfoData fzz;

    /* renamed from: com.baidu.tieba.ala.tasklist.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0485a {
        void a(AlaLiveUserInfoData alaLiveUserInfoData, v vVar);

        void ag(int i, String str);
    }

    public a(TbPageContext<AlaTaskListActivity> tbPageContext) {
        super(tbPageContext);
        this.fzC = new HttpMessageListener(1021065) { // from class: com.baidu.tieba.ala.tasklist.model.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021065 && (httpResponsedMessage instanceof AlaTaskListHttpResponsedMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    AlaTaskListHttpResponsedMessage alaTaskListHttpResponsedMessage = (AlaTaskListHttpResponsedMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        if (a.this.fzB != null) {
                            a.this.fzB.ag(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.fzz = alaTaskListHttpResponsedMessage.fzz;
                    a.this.fzA = alaTaskListHttpResponsedMessage.fzA;
                    if (a.this.fzB != null) {
                        a.this.fzB.a(alaTaskListHttpResponsedMessage.fzz, alaTaskListHttpResponsedMessage.fzA);
                    }
                }
            }
        };
        this.fzD = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.tasklist.model.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        if (a.this.fzB != null) {
                            a.this.fzB.ag(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.fzz = alaTaskRewardHttpResponsedMessage.fzz;
                    a.this.fzA = alaTaskRewardHttpResponsedMessage.fzA;
                    if (a.this.fzB != null) {
                        a.this.fzB.a(alaTaskRewardHttpResponsedMessage.fzz, alaTaskRewardHttpResponsedMessage.fzA);
                    }
                }
            }
        };
        btw();
        btx();
        MessageManager.getInstance().registerListener(this.fzC);
        MessageManager.getInstance().registerListener(this.fzD);
    }

    public v btv() {
        return this.fzA;
    }

    private void btw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021065, com.baidu.live.a.Vq);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaTaskListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void btx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021066, com.baidu.live.a.Vr);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaTaskRewardHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bty() {
        HttpMessage httpMessage = new HttpMessage(1021065);
        httpMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void qT(int i) {
        HttpMessage httpMessage = new HttpMessage(1021066);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("task_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fzC);
        MessageManager.getInstance().unRegisterListener(this.fzD);
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
        this.fzB = interfaceC0485a;
    }
}
