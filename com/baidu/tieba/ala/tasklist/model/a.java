package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.b;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.an;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private AlaLiveUserInfoData hKh;
    private an hKi;
    private InterfaceC0705a hKj;
    private HttpMessageListener hKk = new HttpMessageListener(1021065) { // from class: com.baidu.tieba.ala.tasklist.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021065 && (httpResponsedMessage instanceof LiveFlowerTaskListResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskListResponsedMessage liveFlowerTaskListResponsedMessage = (LiveFlowerTaskListResponsedMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    if (a.this.hKj != null) {
                        a.this.hKj.aE(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                a.this.hKh = liveFlowerTaskListResponsedMessage.hKh;
                a.this.hKi = liveFlowerTaskListResponsedMessage.hKi;
                if (a.this.hKj != null) {
                    a.this.hKj.a(liveFlowerTaskListResponsedMessage.hKh, liveFlowerTaskListResponsedMessage.hKi);
                }
            }
        }
    };
    private HttpMessageListener hKl = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.tasklist.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    if (a.this.hKj != null) {
                        a.this.hKj.aE(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                a.this.hKh = liveFlowerTaskRewardResponsedMessage.hKh;
                a.this.hKi = liveFlowerTaskRewardResponsedMessage.hKi;
                a.this.cln();
                if (a.this.hKj != null) {
                    a.this.hKj.a(liveFlowerTaskRewardResponsedMessage.hKh, liveFlowerTaskRewardResponsedMessage.hKi);
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.tasklist.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0705a {
        void a(AlaLiveUserInfoData alaLiveUserInfoData, an anVar);

        void aE(int i, String str);
    }

    public a() {
        clk();
        cll();
        MessageManager.getInstance().registerListener(this.hKk);
        MessageManager.getInstance().registerListener(this.hKl);
    }

    public an clj() {
        return this.hKi;
    }

    private void clk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021065, b.azU);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cll() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021066, b.azV);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskRewardResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void clm() {
        HttpMessage httpMessage = new HttpMessage(1021065);
        httpMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void wE(int i) {
        HttpMessage httpMessage = new HttpMessage(1021066);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("task_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cln() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_pickup"));
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hKk);
        MessageManager.getInstance().unRegisterListener(this.hKl);
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

    public void a(InterfaceC0705a interfaceC0705a) {
        this.hKj = interfaceC0705a;
    }
}
