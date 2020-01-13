package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
/* loaded from: classes2.dex */
public class a extends BdBaseModel<AlaTaskListActivity> {
    private AlaLiveUserInfoData fwW;
    private u fwX;
    private InterfaceC0477a fwY;
    private HttpMessageListener fwZ;
    private HttpMessageListener fxa;

    /* renamed from: com.baidu.tieba.ala.tasklist.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0477a {
        void a(AlaLiveUserInfoData alaLiveUserInfoData, u uVar);

        void af(int i, String str);
    }

    public a(TbPageContext<AlaTaskListActivity> tbPageContext) {
        super(tbPageContext);
        this.fwZ = new HttpMessageListener(1021065) { // from class: com.baidu.tieba.ala.tasklist.model.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021065 && (httpResponsedMessage instanceof AlaTaskListHttpResponsedMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    AlaTaskListHttpResponsedMessage alaTaskListHttpResponsedMessage = (AlaTaskListHttpResponsedMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        if (a.this.fwY != null) {
                            a.this.fwY.af(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.fwW = alaTaskListHttpResponsedMessage.fwW;
                    a.this.fwX = alaTaskListHttpResponsedMessage.fwX;
                    if (a.this.fwY != null) {
                        a.this.fwY.a(alaTaskListHttpResponsedMessage.fwW, alaTaskListHttpResponsedMessage.fwX);
                    }
                }
            }
        };
        this.fxa = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.tasklist.model.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        if (a.this.fwY != null) {
                            a.this.fwY.af(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.fwW = alaTaskRewardHttpResponsedMessage.fwW;
                    a.this.fwX = alaTaskRewardHttpResponsedMessage.fwX;
                    if (a.this.fwY != null) {
                        a.this.fwY.a(alaTaskRewardHttpResponsedMessage.fwW, alaTaskRewardHttpResponsedMessage.fwX);
                    }
                }
            }
        };
        brQ();
        brR();
        MessageManager.getInstance().registerListener(this.fwZ);
        MessageManager.getInstance().registerListener(this.fxa);
    }

    public u brP() {
        return this.fwX;
    }

    private void brQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021065, com.baidu.live.a.TK);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaTaskListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void brR() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021066, com.baidu.live.a.TL);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaTaskRewardHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void brS() {
        HttpMessage httpMessage = new HttpMessage(1021065);
        httpMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void qM(int i) {
        HttpMessage httpMessage = new HttpMessage(1021066);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("task_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fwZ);
        MessageManager.getInstance().unRegisterListener(this.fxa);
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

    public void a(InterfaceC0477a interfaceC0477a) {
        this.fwY = interfaceC0477a;
    }
}
