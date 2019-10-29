package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
/* loaded from: classes6.dex */
public class a extends BdBaseModel<AlaTaskListActivity> {
    private AlaLiveUserInfoData eCX;
    private q eCY;
    private InterfaceC0389a eCZ;
    private HttpMessageListener eDa;
    private HttpMessageListener eDb;

    /* renamed from: com.baidu.tieba.ala.tasklist.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0389a {
        void P(int i, String str);

        void a(AlaLiveUserInfoData alaLiveUserInfoData, q qVar);
    }

    public a(TbPageContext<AlaTaskListActivity> tbPageContext) {
        super(tbPageContext);
        this.eDa = new HttpMessageListener(1021065) { // from class: com.baidu.tieba.ala.tasklist.model.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021065 && (httpResponsedMessage instanceof AlaTaskListHttpResponsedMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    AlaTaskListHttpResponsedMessage alaTaskListHttpResponsedMessage = (AlaTaskListHttpResponsedMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        if (a.this.eCZ != null) {
                            a.this.eCZ.P(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.eCX = alaTaskListHttpResponsedMessage.eCX;
                    a.this.eCY = alaTaskListHttpResponsedMessage.eCY;
                    if (a.this.eCZ != null) {
                        a.this.eCZ.a(alaTaskListHttpResponsedMessage.eCX, alaTaskListHttpResponsedMessage.eCY);
                    }
                }
            }
        };
        this.eDb = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.tasklist.model.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        if (a.this.eCZ != null) {
                            a.this.eCZ.P(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.eCX = alaTaskRewardHttpResponsedMessage.eCX;
                    a.this.eCY = alaTaskRewardHttpResponsedMessage.eCY;
                    if (a.this.eCZ != null) {
                        a.this.eCZ.a(alaTaskRewardHttpResponsedMessage.eCX, alaTaskRewardHttpResponsedMessage.eCY);
                    }
                }
            }
        };
        aYP();
        aYQ();
        MessageManager.getInstance().registerListener(this.eDa);
        MessageManager.getInstance().registerListener(this.eDb);
    }

    public q aYO() {
        return this.eCY;
    }

    private void aYP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021065, com.baidu.live.a.Nm);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaTaskListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void aYQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021066, com.baidu.live.a.Nn);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaTaskRewardHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void aYR() {
        HttpMessage httpMessage = new HttpMessage(1021065);
        httpMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void oo(int i) {
        HttpMessage httpMessage = new HttpMessage(1021066);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("task_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eDa);
        MessageManager.getInstance().unRegisterListener(this.eDb);
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

    public void a(InterfaceC0389a interfaceC0389a) {
        this.eCZ = interfaceC0389a;
    }
}
